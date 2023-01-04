create table assembly_order
(
    id INT GENERATED BY DEFAULT AS IDENTITY(START WITH 5) PRIMARY KEY,
    goods_id VARCHAR(255),
    shop_order_id VARCHAR(255),
    quantity INT,
    status VARCHAR(20) DEFAULT 'NEW' NOT NULL,
    tracking_nr VARCHAR(255),
    assigned_to INT,
    metadata VARCHAR(10000),
    placement_date TIMESTAMPTZ,
    last_updated TIMESTAMPTZ NOT NULL DEFAULT now()
);