<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">

        <il:objetoEventoOperacion xmlns:il="http://aesveln.com.co/transfor/il/">
            <il:informacionOficina>
                <il:numero>
                    <xsl:value-of
                            select="/*[name() = 'enterpriseOperationEventObject']/*[name() = 'branchOfficeInfo']/*[name() = 'lineNumber']/text()"/>
                </il:numero>
                <il:nombreOficina>
                    <xsl:value-of
                            select="/*[name() = 'enterpriseOperationEventObject']/*[name() = 'branchOfficeInfo']/*[name() = 'name']/text()"/>
                </il:nombreOficina>
                <il:licencia>
                    <xsl:value-of
                            select="/*[name() = 'enterpriseOperationEventObject']/*[name() = 'branchOfficeInfo']/*[name() = 'assignedLicense']/text()"/>
                </il:licencia>
            </il:informacionOficina>

            <il:informacionUsuario>
                <il:nombreCompleto>
                    <xsl:value-of
                            select="/*[name() = 'enterpriseOperationEventObject']/*[name() = 'customerInfo']/*[name() = 'fullName']/text()"/>
                </il:nombreCompleto>
                <il:id>
                    <xsl:value-of
                            select="/*[name() = 'enterpriseOperationEventObject']/*[name() = 'customerInfo']/*[name() = 'id']/text()"/>
                </il:id>
                <il:esCompania>
                    <xsl:value-of
                            select="/*[name() = 'enterpriseOperationEventObject']/*[name() = 'customerInfo']/*[name() = 'isACompany']/text()"/>
                </il:esCompania>
                <il:informacionContacto>
                    <il:direccion>
                        <xsl:value-of
                                select="/*[name() = 'enterpriseOperationEventObject']/*[name() = 'customerInfo']/*[name() = 'contactInfo']/*[name() = 'address']/text()"/>
                    </il:direccion>
                    <il:correo>
                        <xsl:value-of
                                select="/*[name() = 'enterpriseOperationEventObject']/*[name() = 'customerInfo']/*[name() = 'contactInfo']/*[name() = 'email']/text()"/>
                    </il:correo>
                    <il:telefono1>
                        <xsl:value-of
                                select="/*[name() = 'enterpriseOperationEventObject']/*[name() = 'customerInfo']/*[name() = 'contactInfo']/*[name() = 'phoneNumber1']/text()"/>
                    </il:telefono1>
                    <il:telefono2>
                        <xsl:value-of
                                select="/*[name() = 'enterpriseOperationEventObject']/*[name() = 'customerInfo']/*[name() = 'contactInfo']/*[name() = 'phoneNumber2']/text()"/>
                    </il:telefono2>
                </il:informacionContacto>
            </il:informacionUsuario>
            <xsl:for-each
                    select="/*[name() = 'enterpriseOperationEventObject']/*[name() = 'financialActionDomainObject']">
                <il:objectoAccionFinanciera>
                    <xsl:if test="*[name() = 'financialProduct']/*[name() = 'type']">
                        <il:productoFinanciero>
                            <il:tipo>
                                <xsl:value-of
                                        select="*[name() = 'financialProduct']/*[name() = 'type']"/>
                            </il:tipo>
                            <il:descripcion>
                                <xsl:value-of
                                        select="*[name() = 'financialProduct']/*[name() = 'description']"/>
                            </il:descripcion>

                            <il:eventoProdutoEmpresarial>
                                <xsl:if test="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'addDomainEvent']">
                                    <il:eventoAdicion/>
                                    <xsl:if test="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'addCheckingAccountDomainEvent']">
                                        <il:adicionarCuentaCorrienteEvento>
                                            <il:numeroReferenciaChek>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'addCheckingAccountDomainEvent']/*[name() = 'checkbookReferecenNumber']/text()"/>
                                            </il:numeroReferenciaChek>
                                            <il:numeroCuenta>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'addCheckingAccountDomainEvent']/*[name() = 'accountNumber']/text()"/>
                                            </il:numeroCuenta>
                                            <il:saldoInicial>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'addCheckingAccountDomainEvent']/*[name() = 'initialFunds']/text()"/>
                                            </il:saldoInicial>
                                        </il:adicionarCuentaCorrienteEvento>
                                    </xsl:if>
                                    <xsl:if test="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'addSavingAccountDomainEvent']">
                                        <il:adicionarCuentaAhorrosEvento>
                                            <il:numeroReferenciaChek>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'addSavingAccountDomainEvent']/*[name() = 'checkbookReferecenNumber']/text()"/>
                                            </il:numeroReferenciaChek>
                                            <il:numeroCuenta>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'addSavingAccountDomainEvent']/*[name() = 'accountNumber']/text()"/>
                                            </il:numeroCuenta>
                                            <il:saldoInicial>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'addSavingAccountDomainEvent']/*[name() = 'initialFunds']/text()"/>
                                            </il:saldoInicial>
                                        </il:adicionarCuentaAhorrosEvento>
                                    </xsl:if>
                                    <xsl:if test="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'addCardDomainEvent']">
                                        <il:adicionarTarjeta>
                                            <il:numeroCuenta>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'addCardDomainEvent']/*[name() = 'accountNumber']/text()"/>
                                            </il:numeroCuenta>
                                            <il:tipoCuenta>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'addCardDomainEvent']/*[name() = 'accountType']/text()"/>
                                            </il:tipoCuenta>
                                            <il:tipoTarjeta>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'addCardDomainEvent']/*[name() = 'cardType']/text()"/>
                                            </il:tipoTarjeta>
                                        </il:adicionarTarjeta>
                                    </xsl:if>
                                    <xsl:if test="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'addLoanDomainEvent']">
                                        <il:adicionarPrestamo>
                                            <il:numeroPrestamos>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'addLoanDomainEvent']/*[name() = 'loanNumber']/text()"/>
                                            </il:numeroPrestamos>
                                            <il:montoSolicitado>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'addLoanDomainEvent']/*[name() = 'requestedAmount']/text()"/>
                                            </il:montoSolicitado>
                                            <il:totalCargos>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'addLoanDomainEvent']/*[name() = 'totalFees']/text()"/>
                                            </il:totalCargos>
                                        </il:adicionarPrestamo>
                                    </xsl:if>
                                </xsl:if>

                                <xsl:if test="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'cancelDomainEvent']">
                                    <il:eventoCancelacion/>
                                    <xsl:if test="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'cancelCheckingAccountDomainEvent']">
                                        <il:cancelarCuentaCorrienteEvento>
                                            <il:numeroReferenciaChek>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'cancelCheckingAccountDomainEvent']/*[name() = 'checkbookReferecenNumber']/text()"/>
                                            </il:numeroReferenciaChek>
                                            <il:numeroCuenta>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'cancelCheckingAccountDomainEvent']/*[name() = 'accountNumber']/text()"/>
                                            </il:numeroCuenta>
                                            <il:saldoInicial>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'cancelCheckingAccountDomainEvent']/*[name() = 'initialFunds']/text()"/>
                                            </il:saldoInicial>
                                        </il:cancelarCuentaCorrienteEvento>
                                    </xsl:if>
                                    <xsl:if test="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'cancelSavingAccountDomainEvent']">
                                        <il:cancelarCuentaAhorrosEvento>
                                            <il:numeroReferenciaChek>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'cancelSavingAccountDomainEvent']/*[name() = 'checkbookReferecenNumber']/text()"/>
                                            </il:numeroReferenciaChek>
                                            <il:numeroCuenta>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'cancelSavingAccountDomainEvent']/*[name() = 'accountNumber']/text()"/>
                                            </il:numeroCuenta>
                                            <il:saldoInicial>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'cancelSavingAccountDomainEvent']/*[name() = 'initialFunds']/text()"/>
                                            </il:saldoInicial>
                                        </il:cancelarCuentaAhorrosEvento>
                                    </xsl:if>
                                    <xsl:if test="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'cancelCardDomainEvent']">
                                        <il:cancelarTarjeta>
                                            <il:numeroCuenta>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'cancelCardDomainEvent']/*[name() = 'accountNumber']/text()"/>
                                            </il:numeroCuenta>
                                            <il:tipoCuenta>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'cancelCardDomainEvent']/*[name() = 'accountType']/text()"/>
                                            </il:tipoCuenta>
                                            <il:tipoTarjeta>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'cancelCardDomainEvent']/*[name() = 'cardType']/text()"/>
                                            </il:tipoTarjeta>
                                        </il:cancelarTarjeta>
                                    </xsl:if>
                                    <xsl:if test="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'cancelLoanDomainEvent']">
                                        <il:cancelarPrestamo>
                                            <il:numeroPrestamos>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'cancelLoanDomainEvent']/*[name() = 'loanNumber']/text()"/>
                                            </il:numeroPrestamos>
                                            <il:montoSolicitado>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'cancelLoanDomainEvent']/*[name() = 'requestedAmount']/text()"/>
                                            </il:montoSolicitado>
                                            <il:totalCargos>
                                                <xsl:value-of
                                                        select="*[name() = 'financialProduct']/*[name() = 'enterpriseProductsDomainEvents']/*[name() = 'cancelLoanDomainEvent']/*[name() = 'totalFees']/text()"/>
                                            </il:totalCargos>
                                        </il:cancelarPrestamo>
                                    </xsl:if>

                                </xsl:if>

                            </il:eventoProdutoEmpresarial>

                        </il:productoFinanciero>
                    </xsl:if>
                    <xsl:if test="*[name() = 'financialService']">
                        <il:servicioFinanciero>
                            <il:tipo>
                                <xsl:value-of
                                        select="*[name() = 'financialService']/*[name() = 'type']"/>
                            </il:tipo>
                            <il:descripcion>
                                <xsl:value-of
                                        select="*[name() = 'financialService']/*[name() = 'description']"/>
                            </il:descripcion>

                            <il:eventoServicioEmpresarial>
                                <xsl:if test="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'addDomainEvent']">
                                    <il:eventoAdicion/>
                                    <xsl:if test="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'executeElectronicPaymentDomainEvent']">
                                        <il:ejecutarPagoElectronico>
                                            <il:valor>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'executeElectronicPaymentDomainEvent']/*[name() = 'value']/text()"/>
                                            </il:valor>
                                            <il:numeroCuentaOrigen>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'executeElectronicPaymentDomainEvent']/*[name() = 'sourceAccountNumber']/text()"/>
                                            </il:numeroCuentaOrigen>
                                            <il:tipoCuentaOrigen>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'executeElectronicPaymentDomainEvent']/*[name() = 'sourceAccountType']/text()"/>
                                            </il:tipoCuentaOrigen>
                                            <il:codigoBancoDestino>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'executeElectronicPaymentDomainEvent']/*[name() = 'targetBankCode']/text()"/>
                                            </il:codigoBancoDestino>
                                            <il:numeroCuentaDestino>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'executeElectronicPaymentDomainEvent']/*[name() = 'targetAccountNumber']/text()"/>
                                            </il:numeroCuentaDestino>
                                            <il:tipoCuentaDestino>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'executeElectronicPaymentDomainEvent']/*[name() = 'targetAccountType']/text()"/>
                                            </il:tipoCuentaDestino>
                                        </il:ejecutarPagoElectronico>
                                    </xsl:if>

                                    <xsl:if test="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'executeDomesticPaymentDomainEvent']">
                                        <il:ejecutarPagoDomestico>
                                            <il:varlorRetorno>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'executeDomesticPaymentDomainEvent']/*[name() = 'cashValue']/text()"/>
                                            </il:varlorRetorno>
                                            <il:codigoLimpieza>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'executeDomesticPaymentDomainEvent']/*[name() = 'clearingHouseCode']/text()"/>
                                            </il:codigoLimpieza>
                                            <il:numeroCuentaDestino>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'executeDomesticPaymentDomainEvent']/*[name() = 'targetAccountNumber']/text()"/>
                                            </il:numeroCuentaDestino>
                                            <il:tipoCuentaDestino>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'executeDomesticPaymentDomainEvent']/*[name() = 'targetAccountType']/text()"/>
                                            </il:tipoCuentaDestino>
                                        </il:ejecutarPagoDomestico>
                                    </xsl:if>

                                    <xsl:if test="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'executeAccountToAccountPaymentDomainEvent']">

                                        <il:ejecutarPagoCuentaACuenta>
                                            <il:valor>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'executeAccountToAccountPaymentDomainEvent']/*[name() = 'value']/text()"/>
                                            </il:valor>
                                            <il:numeroCuentaOrigen>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'executeAccountToAccountPaymentDomainEvent']/*[name() = 'sourceAccountNumber']/text()"/>
                                            </il:numeroCuentaOrigen>
                                            <il:tipoCuentaOrigen>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'executeAccountToAccountPaymentDomainEvent']/*[name() = 'sourceAccountType']/text()"/>
                                            </il:tipoCuentaOrigen>
                                            <il:numeroCuentaDestino>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'executeAccountToAccountPaymentDomainEvent']/*[name() = 'targetAccountNumber']/text()"/>
                                            </il:numeroCuentaDestino>
                                            <il:tipoCuentaDestino>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'executeAccountToAccountPaymentDomainEvent']/*[name() = 'targetAccountType']/text()"/>
                                            </il:tipoCuentaDestino>
                                        </il:ejecutarPagoCuentaACuenta>
                                    </xsl:if>

                                </xsl:if>

                                <xsl:if test="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelDomainEvent']">
                                    <il:eventoCancelacion/>
                                    <xsl:if test="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelexecuteElectronicPaymentDomainEvent']">
                                        <il:cancelarPagoElectronico>
                                            <il:valor>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelexecuteElectronicPaymentDomainEvent']/*[name() = 'value']/text()"/>
                                            </il:valor>
                                            <il:numeroCuentaOrigen>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelexecuteElectronicPaymentDomainEvent']/*[name() = 'sourceAccountNumber']/text()"/>
                                            </il:numeroCuentaOrigen>
                                            <il:tipoCuentaOrigen>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelexecuteElectronicPaymentDomainEvent']/*[name() = 'sourceAccountType']/text()"/>
                                            </il:tipoCuentaOrigen>
                                            <il:codigoBancoDestino>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelexecuteElectronicPaymentDomainEvent']/*[name() = 'targetBankCode']/text()"/>
                                            </il:codigoBancoDestino>
                                            <il:numeroCuentaDestino>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelexecuteElectronicPaymentDomainEvent']/*[name() = 'targetAccountNumber']/text()"/>
                                            </il:numeroCuentaDestino>
                                            <il:tipoCuentaDestino>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelexecuteElectronicPaymentDomainEvent']/*[name() = 'targetAccountType']/text()"/>
                                            </il:tipoCuentaDestino>

                                        </il:cancelarPagoElectronico>
                                    </xsl:if>
                                    <xsl:if test="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelexecuteDomesticPaymentDomainEvent']">
                                        <il:cancelarPagoDomestico>
                                            <il:varlorRetorno>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelexecuteDomesticPaymentDomainEvent']/*[name() = 'cashValue']/text()"/>
                                            </il:varlorRetorno>
                                            <il:codigoLimpieza>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelexecuteDomesticPaymentDomainEvent']/*[name() = 'clearingHouseCode']/text()"/>
                                            </il:codigoLimpieza>
                                            <il:numeroCuentaDestino>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelexecuteDomesticPaymentDomainEvent']/*[name() = 'targetAccountNumber']/text()"/>
                                            </il:numeroCuentaDestino>
                                            <il:tipoCuentaDestino>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelexecuteDomesticPaymentDomainEvent']/*[name() = 'targetAccountType']/text()"/>
                                            </il:tipoCuentaDestino>
                                        </il:cancelarPagoDomestico>
                                    </xsl:if>
                                    <xsl:if test="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelexecuteAccountToAccountPaymentDomainEvent']">

                                        <il:cancelarPagoCuentaACuenta>
                                            <il:valor>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelexecuteAccountToAccountPaymentDomainEvent']/*[name() = 'value']/text()"/>
                                            </il:valor>
                                            <il:numeroCuentaOrigen>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelexecuteAccountToAccountPaymentDomainEvent']/*[name() = 'sourceAccountNumber']/text()"/>
                                            </il:numeroCuentaOrigen>
                                            <il:tipoCuentaOrigen>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelexecuteAccountToAccountPaymentDomainEvent']/*[name() = 'sourceAccountType']/text()"/>
                                            </il:tipoCuentaOrigen>
                                            <il:numeroCuentaDestino>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelexecuteAccountToAccountPaymentDomainEvent']/*[name() = 'targetAccountNumber']/text()"/>
                                            </il:numeroCuentaDestino>
                                            <il:tipoCuentaDestino>
                                                <xsl:value-of
                                                        select="*[name() = 'financialService']/*[name() = 'enterpriseServicesDomainEvents']/*[name() = 'cancelexecuteAccountToAccountPaymentDomainEvent']/*[name() = 'targetAccountType']/text()"/>
                                            </il:tipoCuentaDestino>
                                        </il:cancelarPagoCuentaACuenta>
                                    </xsl:if>
                                </xsl:if>


                            </il:eventoServicioEmpresarial>

                        </il:servicioFinanciero>
                    </xsl:if>
                    <xsl:if test="*[name() = 'financialActionDomainEvents']">
                        <il:eventoAccionFinanciera>
                            <xsl:if test="*[name() = 'financialActionDomainEvents']/*[name() = 'addCustomerDomainEvent']">
                                <il:adicionarUsusarioEvento>
                                    <il:esTransferencia>
                                        <xsl:value-of
                                            select="*[name() = 'financialActionDomainEvents']/*[name() = 'addCustomerDomainEvent']/*[name() = 'isTransferred']/text()"/>
                                            </il:esTransferencia>
                                    <il:acuerdo>  <xsl:value-of
                                        select="*[name() = 'financialActionDomainEvents']/*[name() = 'addCustomerDomainEvent']/*[name() = 'agreement']/text()"/>
                                    </il:acuerdo>
                                </il:adicionarUsusarioEvento>
                            </xsl:if>

                        </il:eventoAccionFinanciera>

                    </xsl:if>
                </il:objectoAccionFinanciera>
            </xsl:for-each>

        </il:objetoEventoOperacion>


    </xsl:template>

</xsl:stylesheet>