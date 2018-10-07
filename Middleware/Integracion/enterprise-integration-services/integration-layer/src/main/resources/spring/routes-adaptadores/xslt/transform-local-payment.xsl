<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:sam="http://www.soapui.org/sample/"
                xmlns:il="http://aesveln.com.co/transfor/il/">

    <xsl:template match="/">

        <il:Creation xmlns:il="http://aesveln.com.co/transfor/il/">
            <xsl:choose>

                <xsl:when test="/il:ejecutarPagoDomestico">
                    <cashValue>
                        <xsl:value-of
                                select="/il:ejecutarPagoDomestico/il:varlorRetorno/text()"/>
                    </cashValue>
                    <clearingHouseCode>
                        <xsl:value-of select="/il:ejecutarPagoDomestico/il:codigoLimpieza/text()"/>
                    </clearingHouseCode>
                    <targetAccountNumber>
                        <xsl:value-of
                                select="/il:ejecutarPagoDomestico/il:numeroCuentaDestino/text()"/>
                    </targetAccountNumber>
                    <targetAccountType>
                        <xsl:value-of
                                select="/il:ejecutarPagoDomestico/il:tipoCuentaDestino/text()"/>
                    </targetAccountType>
                </xsl:when>
                <xsl:when test="/il:ejecutarPagoCuentaACuenta">
                    <cashValue>
                        <xsl:value-of
                                select="/il:ejecutarPagoCuentaACuenta/il:varlorRetorno/text()"/>
                    </cashValue>
                    <clearingHouseCode>
                        <xsl:value-of select="/il:ejecutarPagoCuentaACuenta/il:codigoLimpieza/text()"/>
                    </clearingHouseCode>
                    <targetAccountNumber>
                        <xsl:value-of
                                select="/il:ejecutarPagoCuentaACuenta/il:numeroCuentaDestino/text()"/>
                    </targetAccountNumber>
                    <targetAccountType>
                        <xsl:value-of
                                select="/il:ejecutarPagoCuentaACuenta/il:tipoCuentaDestino/text()"/>
                    </targetAccountType>
                </xsl:when>
            </xsl:choose>

        </il:Creation>
    </xsl:template>

</xsl:stylesheet>