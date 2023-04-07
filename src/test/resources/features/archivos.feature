Feature: Como usuario del aplicativo quiero validar las funcionalidades de subir y descargar archivos.


@upLoadFile
Scenario: subir archivo
Given el usuario ingresa al page de subir archivo
When  el usuario selecciona el archivo a cargar "documento pdf"
Then el usuario finaliza la carga