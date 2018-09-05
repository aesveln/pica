create or replace PROCEDURE llenarUsuarios
is
  i integer := 0;
  BEGIN
    FOR i IN 0..17000 LOOP

      INSERT INTO CUSTOMER ("Id",
                            "document_type",
                            "document_number",
                            "first_name",
                            "last_name",
                            "phone_number",
                            "email",
                            "password",
                            "creditcard_type",
                            "creditcard_number",
                            "status",
                            "category")
      VALUES (i,
              CASE round(dbms_random.value(1, 2))
                WHEN 1 THEN 'CC'
                WHEN 2 THEN 'PS'
              END,
              '1' || round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
              round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9))
                || round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
              round(DBMS_RANDOM.VALUE(0, 9))
                || round(DBMS_RANDOM.VALUE(0, 9)),
              concat('Nombre ', i),
              concat('Apellido ', i),
              '1' || round(DBMS_RANDOM.VALUE(2, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
              round(DBMS_RANDOM.VALUE(0, 9)) ||
              round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
              round(DBMS_RANDOM.VALUE(0, 9)),
              concat(i, '@gmail.com'),
              '21232F297A57A5A743894A0E4A801FC3',
              CASE round(dbms_random.value(1, 4))
                WHEN 1 THEN 'AMEX'
                WHEN 2 THEN 'VISA'
                WHEN 3 THEN 'MAST'
                WHEN 4 THEN 'DINE'
              END,
              CASE round(dbms_random.value(1, 4))
                WHEN 1 THEN '37' || round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
                            round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
                            round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
                            round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
                            round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9))
                WHEN 2 THEN '41' || round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
                            round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
                            round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
                            round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
                            round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9))
                WHEN 3 THEN '53' || round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
                            round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
                            round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
                            round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
                            round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9))
                WHEN 4 THEN '54' || round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
                            round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
                            round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
                            round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9)) ||
                            round(DBMS_RANDOM.VALUE(0, 9)) || round(DBMS_RANDOM.VALUE(0, 9))
              END,
              round(DBMS_RANDOM.VALUE(0, 1)), -- 0 Inactivo 1 Activo
              CASE round(dbms_random.value(1, 3))
                WHEN 1 THEN 'Platino'
                WHEN 2 THEN 'Dorado'
                WHEN 3 THEN 'Plateado'
              END);
    END LOOP;
  END;
/
