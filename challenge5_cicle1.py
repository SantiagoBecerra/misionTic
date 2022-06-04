import pandas as pd
# ruta file csv
rutaFileCsv ='https://github.com/luisguillermomolero/MisionTIC2022_2/blob/master/Modulo1_Python_MisionTIC2022_Main/Semana_5/Reto/movies.csv?raw=true'
def listaPeliculas(rutaFileCsv: str) -> str:
    extension = '.csv'
    if(extension in rutaFileCsv):
        try:
             df = pd.read_csv(rutaFileCsv)
        except:
            return '“Error al leer el archivo de datos.”'
        subsetData = df[["Country","Language","Gross Earnings"]]
        pivot = subsetData.pivot_table(index=['Country','Language'],values=['Gross Earnings'])
        return pivot.head(10)
    else:
        return '“Extensión inválida.”.'
print(listaPeliculas(rutaFileCsv))