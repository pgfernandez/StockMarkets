VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "RendezVousConnection"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Attribute VB_Ext_KEY = "SavedWithClassBuilder6" ,"Yes"
Attribute VB_Ext_KEY = "Top_Level" ,"No"
Attribute VB_Ext_KEY = "Member0" ,"MSMQConnection"
Attribute VB_Ext_KEY = "Member1" ,"RendezVousConnection"
'Para activar este evento, use RaiseEvent con la siguiente sintaxis:
'RaiseEvent onMessage[(arg1, arg2, ... , argn)]


'Global data shared among several action routines

Public tib As New Tibrv    ' This will be the RV machinery.

' The transport that we will use to contact the daemon
Public transport As New TibrvTransport

' The queue into which RV places the timer events
Public queue As TibrvQueue

' The queue group for automatic dispatch of timer events
Public queuegroup As TibrvQueueGroup

' A message object
Public msg As TibrvMsg

Public Event onMessage(message As Object)



Public Sub sendMessage(subject As String, name As String, message As String)
   
   
'   msg.Reset
   
   
       msg.Add name, message
    
    
    ' Set the subject we will use to send this msg.
    msg.setSendSubject subject

    ' Pass the message to the transport to get it sent.
    transport.send msg
   
  
  
End Sub

Public Sub connect()



   
    'First, open the Rv system.  This method creates all the underlying
    ' mechanisms that will be used to handle events and send messages.
    tib.open
    
    ' Establish a queue group as the autodispatch group.  When a queue
    ' is added to the autodispatch group, this feature causes events
    ' to be dispatched automatically as they arrive in the queue.
    ' In this example, the queue itself is needed only for timer
    ' events when we are sending multiple messages.
    Set queuegroup = tib.getAutoDispatchQueueGroup
    
    ' Get a queue which will be used to handle the timer events.
    ' Since this is a simple program, we will save some effort
    ' and just use the default queue.  In more complex situations,
    ' we may want to create and customize our own queue.
    Set queue = tib.getDefaultQueue
    
    ' Add the default queue to the queue group to enable autodispatch.
    ' Using this group causes events to be dispatched automatically as
    ' they arrive in the queue.  If we forget this step, our callback
    ' will not be executed.
    queuegroup.Add queue
      
    
    ' Create the message object we'll use for sending messages in
    ' the SendOne_Click routine.  We can re-use this object for all
    ' our send actions.
     
 Set msg = New TibrvMsg
    msg.Create
   

End Sub
