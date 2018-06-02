--Insert AREAS_CONSIDERATION reference data records
DECLARE
    V_AC AREA_CONSIDERATION%ROWTYPE;
BEGIN
    --Insert DE record
    V_AC.AREA_CONSIDER_CODE    := 'DE';
    V_AC.AREA_CONSIDER_DESC    := 'Delegated Examining';

    INSERT INTO AREA_CONSIDERATION VALUES V_AC;

    --Insert ST record
    V_AC.AREA_CONSIDER_CODE    := 'ST';
    V_AC.AREA_CONSIDER_DESC    := 'Status';

    INSERT INTO AREA_CONSIDERATION VALUES V_AC;

    --Insert IMP record
    V_AC.AREA_CONSIDER_CODE    := 'IMP';
    V_AC.AREA_CONSIDER_DESC    := 'Internal Merit Promotion';

    INSERT INTO AREA_CONSIDERATION VALUES V_AC;

    COMMIT;

END;
/