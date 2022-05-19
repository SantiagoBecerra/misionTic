def CDT(user: str,capital: int,time: int):
    if len(user) > 0 and capital > 0 and time > 0: 
        if time > 2:
            val = (capital*0.03*time)/12
            cdt = val + capital
        else:    
            val = capital*0.02
            cdt = capital-val
        response = 'Para el usuario ' + user + ' La cantidad de dinero a recibir, según el monto inicial ' + str(capital) + ' para un tiempo de ' + str(time) + ' meses es: ' + str(cdt) 
        return response
    else:
        print('Porfavor digite los valores correctamente')