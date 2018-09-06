create or replace PROCEDURE llenarOrderItem (inicio number, fin number) as

  i             INTEGER := 0;
  codProdSpec   varchar(20);
  codProdTrans  varchar(20);
  codProdLod    varchar(20);
  nameProdSpec  varchar(200);
  nameProdTrans varchar(200);
  nameProdLod   varchar(200);
  precioSpec    integer;
  precioTr      integer;
  precioLod     integer;
  personas integer;
  orderId  integer;
  randSpec integer;
  randTr   integer;
  randLd   integer;

  begin
    for i in inicio..fin loop
      begin
        orderId := concat('5491', i);

        randSpec := round(dbms_random.value(800001, 1000000));
        randTr := round(dbms_random.value(400001, 800000));
        randLd := round(dbms_random.value(0, 400000));

        select cod,NAME,COST INTO codProdSpec,nameProdSpec,precioSpec
        from ADMCYO.PRODUCT
        where ID = randSpec;
--
--         select cod,NAME,COST INTO codProdTrans,nameProdTrans,precioTr
--         from ADMCYO.PRODUCT
--           WHERE  ID = randTr;
--
--         select cod,NAME,COST INTO codProdLod,nameProdLod,precioLod
--         from ADMCYO.PRODUCT
--           WHERE ID = randLd;


        INSERT INTO ORDER_ITEM ("PRODUCT_COD", "PRODUCT_NAME", "PRICE", "QUANTITY", "ORDER_ID")
        VALUES (codProdSpec, nameProdSpec, precioSpec, personas, orderId);
--         INSERT INTO ORDER_ITEM ("PRODUCT_COD", "PRODUCT_NAME", "PRICE", "QUANTITY", "ORDER_ID")
--         VALUES (codProdTrans, nameProdTrans, precioTr, personas, orderId);
--         INSERT INTO ORDER_ITEM ("PRODUCT_COD", "PRODUCT_NAME", "PRICE", "QUANTITY", "ORDER_ID")
--         VALUES (codProdLod, nameProdLod, precioLod, personas, orderId);
      end;

    END loop;
  end;
/

BEGIN
  LLENARORDERITEM(8001,10000);
end;

BEGIN
  LLENARORDERITEM(6001,8000);
end;

BEGIN
  LLENARORDERITEM(5001,6000);
end;

BEGIN
  LLENARORDERITEM(0,5000);
end;