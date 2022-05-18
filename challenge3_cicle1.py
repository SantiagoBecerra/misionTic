def AutoPartes(ventas: list):
    dicVentas = {}
    for index, tuple in enumerate(ventas):
        dicVentas["Venta " + str(index + 1)] = (
            tuple[0],
            tuple[1],
            tuple[2],
            tuple[3],
            tuple[4],
            tuple[5],
            tuple[6],
            tuple[7],
        )
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


consultaRegistro(
    AutoPartes(
        (
            [
                (2001, "rosca", "PT29872", 2, 45, "Luis Molero", 3456, "12/06/2020"),
                (2010, "bujía", "MS9512", 4, 15, "Carlos Rondon", 1256, "12/06/2020"),
                (2010, "bujía", "ER6523", 9, 36, "Pedro Montes", 1243, "12/06/2020"),
                (3578, "tijera", "QW8523", 1, 128, "Pedro Faria", 1456, "12/06/2020"),
                (9251, "piñón", "EN5698", 2, 8, "Juan Peña", 565, "12/06/2020"),
            ]
        )
    ),2010
)


