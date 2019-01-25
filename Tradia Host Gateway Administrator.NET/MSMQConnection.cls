VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "MSMQConnection"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Attribute VB_Ext_KEY = "SavedWithClassBuilder6" ,"Yes"
Attribute VB_Ext_KEY = "Top_Level" ,"No"
Attribute VB_Ext_KEY = "Member0" ,"MSMQConnection"
'Para activar este evento, use RaiseEvent con la siguiente sintaxis:
'RaiseEvent onMessage[(arg1, arg2, ... , argn)]
Public Event onMessage(message As Object)
Dim qDest As MSMQQueue
Dim qOrig As MSMQQueue
Public queueInfo As MSMQQueueInfo


Public Sub sendMessage(title As String, message As String)
'receiveMessage
'abre cola
'escribe
'cierra cola
'posibilidad transaccion
  Dim msg As New MSMQMessage
  
  ' Create a direct format name.
  'strFormatName = "DIRECT=OS:obelix\tradia"
   
  ' Set the FormatName property of the MSMQQueueInfo object.
  On Error GoTo ErrorHandler
  'qinfo.FormatName = strFormatName
  
  
  ' Open the queue.
  Set qDest = queueInfo.open(MQ_SEND_ACCESS, MQ_DENY_NONE)
  
  ' Set message properties.
  msg.label = title
  msg.Body = message
    
  ' Send the message and close the queue.
  msg.send DestinationQueue:=qDest
  qDest.Close

  Exit Sub
  
ErrorHandler:
  MsgBox "Error " + Hex(Err.Number) + " was returned." _
         + Chr(13) + Err.Description
End Sub

Public Sub connect()
  
  Set queueInfo = New MSMQQueueInfo
    
  
  Dim Queue As MSMQQueue

   queueInfo.PathName = ".\private$\tradia"
   
  'Set Queue = queueInfo.open(MQ_SEND_ACCESS, MSMQ.MQ_DENY_NONE)
  
  
End Sub

Public Sub receiveMessage()
  
  Set qOrig = queueInfo.open(MQ_RECEIVE_ACCESS, MQ_DENY_NONE)
  
Set qevent = New MSMQEvent
  qOrig.EnableNotification Event:=qevent, ReceiveTimeout:=10000

  ' Start a DoEvents loop to prevent the thread from exiting.
  Dim wait As Long
  For wait = 1 To 10000
    DoEvents
  Next
  
  'While True
    
   ' DoEvents
  
  'Wend
  
  Exit Sub
  
ErrorHandler:
  MsgBox "Unexpected error!" + Chr(13) + "Reason: " + Err.Description _
          + Chr(13) + "Error: " + Hex(Err.Number)
End Sub


Private Sub qevent_Arrived(ByVal q As Object, ByVal lCursor As Long)
  
  Dim msg As MSMQMessage
 
  On Error GoTo ErrorHandler
  ' Read the message that fired the Arrived event from the queue.
  Set msg = q.Receive(Transaction:=MQ_NO_TRANSACTION, ReceiveTimeout:=0)
  If Not msg Is Nothing Then
    MsgBox "Removed message from the queue."
  End If
  qOrig.EnableNotification Event:=qevent, ReceiveTimeout:=10000
  Exit Sub
    
ErrorHandler:
  MsgBox "Unexpected error!" + Chr(13) + "Reason: " + Err.Description _
          + Chr(13) + "Error: " + Hex(Err.Number)
  q.EnableNotification Event:=qevent, ReceiveTimeout:=1000
End Sub


Private Sub qevent_ArrivedError(ByVal q As Object, ByVal lError As Long, ByVal lCursor As Long)
  On Error GoTo ErrorHandler
  If lError = MQ_ERROR_IO_TIMEOUT Then
    MsgBox "No message arrived during the time-out period."
  Else
    MsgBox "An arrived-error event occurred. Error: " + Hex(lError)
  End If
  End
  Exit Sub
    
ErrorHandler:
  MsgBox "Unexpected error!" + Chr(13) + "Reason: " + Err.Description _
          + Chr(13) + "Error: " + Hex(Err.Number)
  End
End Sub
  




