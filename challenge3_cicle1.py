def AutoPartes(ventas: list):
    dicVentas = {}
    count = 1
    for index, tuple in enumerate(ventas):
        dicVentas["Venta " + str(count)] = (
            tuple[0],
            tuple[1],
            tuple[2],
            tuple[3],
            tuple[4],
            tuple[5],
            tuple[6],
            tuple[7],
        )
        count += 1
    return dicVentas


def consultaRegistro(ventas, idProducto):
    notIn = True    
    strRes = ""
    for numventa, id in ventas.items():
        if id[0] == idProducto:
            strRes += "Producto consultado : {}  Descripción  {}  #Parte  {}  Cantidad vendida  {}  Stock  {}  Comprador {}  Documento  {}  Fecha Venta  {} \n".format(
                idProducto, id[1], id[2], id[3], id[4], id[5], id[6], id[7]
            )
            notIn = False
    if notIn:
        strRes = "No hay registro de venta de ese producto"
    print(strRes)
