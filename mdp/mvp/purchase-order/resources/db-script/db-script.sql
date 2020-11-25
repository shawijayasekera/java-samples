/* Table structure */

CREATE TABLE users(
   id serial PRIMARY KEY,
   firstname VARCHAR (50),
   lastname VARCHAR (50),
   state VARCHAR(10)
);

CREATE TABLE product(
   id serial PRIMARY KEY,
   description VARCHAR (500),
   price numeric (10,2) NOT NULL
);

CREATE TABLE purchase_order(
    id serial PRIMARY KEY,
    user_id integer references users (id),
    product_id integer references product (id)
);

/* Query for get the summary data */
select 
    u.state,
    sum(p.price) as total_sale
from 
    users u,
    product p,
    purchase_order po
where 
    u.id = po.user_id
    and p.id = po.product_id
group by u.state
order by u.state

/* View for get the summary data */
create view purchase_order_summary
as
select u.state,
       sum(p.price) as total_sale
from users u,
     product p,
     purchase_order po
where u.id = po.user_id
  and p.id = po.product_id
group by u.state
order by u.state

/* Query for get the data from view */
select * from purchase_order_summary;

/* Materialized view */
CREATE MATERIALIZED VIEW purchase_order_summary
AS
select 
    u.state,
    sum(p.price) as total_sale
from 
    users u,
    product p,
    purchase_order po
where 
    u.id = po.user_id
    and p.id = po.product_id
group by u.state
order by u.state
WITH NO DATA;
CREATE UNIQUE INDEX state_category ON purchase_order_summary (state);

/* To load into the purchase_order_summary */
REFRESH MATERIALIZED VIEW CONCURRENTLY purchase_order_summary;

/* Function for update the materialized view */
CREATE OR REPLACE FUNCTION refresh_mat_view()
  RETURNS TRIGGER LANGUAGE plpgsql
  AS $$
  BEGIN
  REFRESH MATERIALIZED VIEW CONCURRENTLY purchase_order_summary;
  RETURN NULL;
  END $$;

/* Database trigger to call the function. This will trigger for every insert */
CREATE TRIGGER refresh_mat_view_after_po_insert
  AFTER INSERT 
  ON purchase_order
  FOR EACH STATEMENT
  EXECUTE PROCEDURE refresh_mat_view();

/* Drop trigger */
drop trigger refresh_mat_view_after_po_insert ON purchase_order;

/* Drop function */
drop function refresh_mat_view();

/* Create procedure */
CREATE OR REPLACE PROCEDURE refresh_mat_view()
LANGUAGE plpgsql    
AS $$
BEGIN
  REFRESH MATERIALIZED VIEW CONCURRENTLY purchase_order_summary;
END;
$$;