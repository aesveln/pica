CREATE OR REPLACE PROCEDURE llenarUsuarios
is
  i integer := 0;
  BEGIN
    FOR i IN 0..17000 LOOP
     insert into ADMCYO.CUSTOMER
         ("Id", "first_name", "last_name", "phone_number","email", "password",
          "creditcard_type", "creditcard_number", "status", "category")
     values ( concat('0000',i), concat('Nombre ',i), concat('Apellido ',i),
             '1' || round(DBMS_RANDOM.VALUE(2,9)) || round(DBMS_RANDOM.VALUE(0,9)) ||round(DBMS_RANDOM.VALUE(0,9))||
                 round(DBMS_RANDOM.VALUE(0,9)) ||  round(DBMS_RANDOM.VALUE(0,9)) ||round(DBMS_RANDOM.VALUE(0,9))||
                round(DBMS_RANDOM.VALUE(0,9)),
             concat(i,'@gmail.com'),
             '15E2B0D3C33891EBB0F1EF609EC419420C20E320CE94C65FBC8C3312448EB225',
                            CASE round(dbms_random.value(1,4))
                    WHEN 1 THEN 'AMEX'
                    WHEN 2 THEN 'VISA'
                    WHEN 3 THEN 'MAST'
                    WHEN 4 THEN 'DINE'
               END,
               CASE round(dbms_random.value(1,4))
                    WHEN 1 THEN '37' || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9))
                    WHEN 2 THEN '41' || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9))
                    WHEN 3 THEN '53' || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9))
                    WHEN 4 THEN '54' || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9)) || round(DBMS_RANDOM.VALUE(0,9))
               END ,
                round(DBMS_RANDOM.VALUE(0,1)),
              CASE round(dbms_random.value(1,3))
                    WHEN 1 THEN 'Platino'
                    WHEN 2 THEN 'Dorado'
                    WHEN 3 THEN 'Plateado'

               END);

    END LOOP;
  END;


