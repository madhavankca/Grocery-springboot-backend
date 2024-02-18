CREATE TABLE CARTITEM (
    ID BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    QUANTITY BIGINT NOT NULL,
    CARTID BIGINT,
    ITEMID BIGINT,
    CONSTRAINT UNIQUE_CART_ITEM_PAIR UNIQUE (CARTID, ITEMID),
    FOREIGN KEY (CARTID) REFERENCES CART(ID),
    FOREIGN KEY (ITEMID) REFERENCES ITEM(ID)
);