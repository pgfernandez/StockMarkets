VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "MessagingConnection"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Attribute VB_Ext_KEY = "SavedWithClassBuilder6" ,"Yes"
Attribute VB_Ext_KEY = "Member0" ,"MSMQConnection"
Attribute VB_Ext_KEY = "Member1" ,"RendezVousConnection"
Attribute VB_Ext_KEY = "Top_Level" ,"Yes"
'Para activar este evento, use RaiseEvent con la siguiente sintaxis:
'RaiseEvent onMessage[(arg1, arg2, ... , argn)]
Public Event onMessage(message As Object)
Private mvarMSMQConnection As MSMQConnection
'Private mvarRendezVousConnection As RendezVousConnection


Public Property Get RendezVousConnection() As RendezVousConnection
    Set RendezVousConnection = mvarRendezVousConnection
End Property


Public Property Set RendezVousConnection(vData As RendezVousConnection)
    Set mvarRendezVousConnection = vData
End Property



Private Sub Class_Initialize()
    'crear el objeto mMSMQConnection cuando se crea la clase MessagingConnection
    Set mvarMSMQConnection = New MSMQConnection
  'crear el objeto mRendezVousConnection cuando se crea la clase MessagingConnection
  'Set mvarRendezVousConnection = New RendezVousConnection
End Sub


Public Property Get MSMQConnection() As MSMQConnection
    Set MSMQConnection = mvarMSMQConnection
End Property


Public Property Set MSMQConnection(vData As MSMQConnection)
    Set mvarMSMQConnection = vData
End Property
Private Sub Class_Terminate()
  Set mvarRendezVousConnection = Nothing
   ' Set mvarMSMQConnection = Nothing
End Sub




Public Sub sendMessage(message As String)
End Sub

