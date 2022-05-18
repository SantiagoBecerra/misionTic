dicJohanaFernandez = {
    "id_cliente": 1,
    "nombre": "Johana Fernandez",
    "edad": 20,
    "primer_ingreso": True,
}
dicGloriaSuarez = {
    "id_cliente": 2,
    "nombre": "Gloria Suarez",
    "edad": 3,
    "primer_ingreso": True,
}
dicTatianaSuarez = {
    "id_cliente": 3,
    "nombre": "Tatiana Suarez",
    "edad": 17,
    "primer_ingreso": True,
}
dicTatianaRuiz = {
    "id_cliente": 4,
    "nombre": "Tatiana Ruiz",
    "edad": 8,
    "primer_ingreso": True,
}

    
def cliente(data: dict) -> dict:
    dicAttract = {}
    dicAttract["X-Treme"] = 20000
    dicAttract["Carros chocones"] = 5000
    dicAttract["Sillas voladoras"] = 10000
    dicRes = {}
    dicRes["nombre"] = data["nombre"]
    dicRes["edad"] = data["edad"]
    if data["edad"] > 18:
        dicRes["atraccion"] = str(list(dicAttract.keys())[0])
        dicRes["apto"] = True
        dicRes["primer_ingreso"] = data["primer_ingreso"]
        if data["primer_ingreso"] == True:
            dicRes["total_boleta"] = (
                dicAttract["X-Treme"] - dicAttract["X-Treme"] * 0.05
            )
            data["primer_ingreso"] = False
        else:
            dicRes["total_boleta"] = dicAttract["X-Treme"]
    elif data["edad"] >= 15 and data["edad"] <= 18:
        dicRes["atraccion"] = str(list(dicAttract.keys())[1])
        dicRes["apto"] = True
        dicRes["primer_ingreso"] = data["primer_ingreso"]
        if data["primer_ingreso"] == True:
            dicRes["total_boleta"] = (
                dicAttract["Carros chocones"] - dicAttract["Carros chocones"] * 0.07
            )
            data["primer_ingreso"] = False
        else:
            dicRes["total_boleta"] = dicAttract["Carros chocones"]
    elif data["edad"] >= 7 and data["edad"] < 15:
        dicRes["atraccion"] = str(list(dicAttract.keys())[2])
        dicRes["apto"] = True
        dicRes["primer_ingreso"] = data["primer_ingreso"]
        if data["primer_ingreso"] == True:
            dicRes["total_boleta"] = (
                dicAttract["Sillas voladoras"] - dicAttract["Sillas voladoras"] * 0.05
            )
            data["primer_ingreso"] = False
        else:
            dicRes["total_boleta"] = dicAttract["Sillas voladoras"]
    else:
        dicRes["atraccion"] = "N/A"
        dicRes["apto"] = False
        dicRes["primer_ingreso"] = data["primer_ingreso"]
        dicRes["total_boleta"] = "N/A"
    return dicRes


print(cliente(dicJohanaFernandez))
print(cliente(dicJohanaFernandez))
print(cliente(dicGloriaSuarez))
print(cliente(dicTatianaSuarez))
print(cliente(dicTatianaSuarez))
print(cliente(dicTatianaRuiz))
print(cliente(dicTatianaRuiz))
