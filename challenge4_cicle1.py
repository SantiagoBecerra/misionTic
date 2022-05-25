def ordenes(rutinaContable):
    print('------------------------ Inicio Registro diario ---------------------------------')
    listIds = list(map(int,(map(lambda x: x[0], rutinaContable))))
    ListProds = list(map(lambda x: x[1:], rutinaContable))
    listF,count = [],0.0
    for i in range(len(ListProds)):
        for j in range(len(ListProds[i])):
            count += ListProds[i][j][1]*ListProds[i][j][2]
        if(count < 600000): count = count + 25000
        listF.append(count)
        count = 0.0
    for id,total in zip(listIds,listF):
        print('La factura {} tiene un total en pesos de {:,.2f}'.format(id,total))
    print('-------------------------- Fin Registro diario ----------------------------------')