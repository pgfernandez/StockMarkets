VERSION 5.00
Begin VB.Form formMessaging 
   Caption         =   "Form1"
   ClientHeight    =   3195
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   4680
   LinkTopic       =   "Form1"
   ScaleHeight     =   3195
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command1 
      Caption         =   "Command1"
      Height          =   255
      Left            =   3600
      TabIndex        =   5
      Top             =   2400
      Width           =   735
   End
   Begin VB.ComboBox comboDestinations 
      Height          =   315
      ItemData        =   "formMessaging.frx":0000
      Left            =   960
      List            =   "formMessaging.frx":0002
      TabIndex        =   4
      Text            =   "Select destination"
      Top             =   1080
      Width           =   3255
   End
   Begin VB.TextBox txtMessage 
      Height          =   375
      Left            =   960
      TabIndex        =   1
      Top             =   1560
      Width           =   3255
   End
   Begin VB.CommandButton cmdSend 
      Caption         =   "Send Message"
      Height          =   375
      Left            =   1560
      TabIndex        =   0
      Top             =   2280
      Width           =   1455
   End
   Begin VB.Label labelTo 
      Caption         =   "To:"
      Height          =   255
      Left            =   120
      TabIndex        =   3
      Top             =   1200
      Width           =   735
   End
   Begin VB.Label labelMessage 
      Caption         =   "Message:"
      Height          =   375
      Left            =   120
      TabIndex        =   2
      Top             =   1680
      Width           =   855
   End
End
Attribute VB_Name = "formMessaging"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
  Dim rv As RendezVousConnection
  Dim queueInfo As MSMQQueueInfo
  
  Dim msgConnection As MSMQConnection
    
  Private RequestQueue As MSMQQueue
  Private WithEvents RequestEvent As MSMQEvent
Attribute RequestEvent.VB_VarHelpID = -1
  
  Dim qOrig As MSMQQueue

  
  Dim first As Boolean
 Private Sub cmdSend_Click()
 Dim msgLabel As String
 
 'msgLabel = comboDestinations.Text
  
  msgConnection.connect
  
 ' msgConnection.sendMessage msgLabel, txtMessage.Text
    
  msgConnection.receiveMessage
   

End Sub



Private Sub Command1_Click()
  Dim strFormatName As String
  Dim qinfo As New MSMQQueueInfo
  Dim qDest As MSMQQueue
  Dim msg As New MSMQMessage
  
  ' Create a direct format name.
  strFormatName = "DIRECT=OS:obelix\tradia"
   
  ' Set the FormatName property of the MSMQQueueInfo object.
  On Error GoTo ErrorHandler
  'qinfo.FormatName = strFormatName
  qinfo.PathName = ".\private$\tradia"
  
  ' Open the queue.
  Set qDest = qinfo.open(MQ_SEND_ACCESS, MQ_DENY_NONE)
  
  ' Set message properties.
  msg.label = "Test Message"
  
  ' Send the message and close the queue.
  msg.send DestinationQueue:=qDest
  qDest.Close

  Exit Sub
  
ErrorHandler:
  MsgBox "Error " + Hex(Err.Number) + " was returned." _
         + Chr(13) + Err.Description
End Sub


Private Sub Form_Load()
'   first = True
   
 
'    Set rv = New RendezVousConnection
  
 ' If first Then
   
  
  '  rv.connect
   ' first = False
    
 ' End If
 
 Set msgConnection = New MSMQConnection
     
 comboDestinations.AddItem ("Gateway")
 comboDestinations.AddItem ("Users")
 comboDestinations.AddItem ("Log")
  
 
 Me.Show
 

End Sub

Public Sub setTransport(transport As RendezVousConnection)
  
  
  
  Load Me
  
  
End Sub


Sub RequestEvent_Arrived(ByVal Queue As Object, _
                          ByVal Cursor As Long)
   Dim RequestQueue As MSMQQueue
   ' cast to MSMQQueue to avoid late binding
   Set RequestQueue = Queue
   Dim msg As MSMQMessage
   Set msg = RequestQueue.Receive(ReceiveTimeout:=0)
   If Not (msg Is Nothing) Then
     
     txtMessage.Text = msg.Body
     
     
   End If
   RequestQueue.EnableNotification RequestEvent
 End Sub


  End
End Sub
  






