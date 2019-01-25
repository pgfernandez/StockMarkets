VERSION 5.00
Object = "{248DD890-BB45-11CF-9ABC-0080C7E7B78D}#1.0#0"; "MSWINSCK.OCX"
Object = "{831FDD16-0C5C-11D2-A9FC-0000F8754DA1}#2.0#0"; "Mscomctl.ocx"
Begin VB.Form formMain 
   BackColor       =   &H0080C0FF&
   Caption         =   "Tradia Host Gateway Admnistration"
   ClientHeight    =   9435
   ClientLeft      =   -120
   ClientTop       =   630
   ClientWidth     =   11400
   LinkTopic       =   "Form1"
   ScaleHeight     =   9435
   ScaleWidth      =   11400
   StartUpPosition =   2  'CenterScreen
   WindowState     =   2  'Maximized
   Begin VB.Frame frameOperator 
      BackColor       =   &H00C0FFFF&
      Caption         =   "Operator"
      Height          =   1095
      Left            =   0
      TabIndex        =   16
      Top             =   7920
      Width           =   3615
      Begin VB.CommandButton cmdUsers 
         Caption         =   "Manage Users"
         Height          =   375
         Left            =   1800
         TabIndex        =   18
         Top             =   240
         Width           =   1695
      End
      Begin VB.CommandButton cmdMessage 
         BackColor       =   &H0080C0FF&
         Caption         =   "Send Message"
         Height          =   375
         Left            =   120
         MaskColor       =   &H0080C0FF&
         TabIndex        =   17
         Top             =   240
         Width           =   1695
      End
   End
   Begin VB.Frame frameGateway 
      BackColor       =   &H00C0FFFF&
      Caption         =   "Gateway"
      Height          =   1095
      Left            =   3840
      TabIndex        =   13
      Top             =   7920
      Width           =   3615
      Begin VB.CommandButton cmdDixonnectGW 
         Caption         =   "Disconnect Gateway"
         Height          =   375
         Left            =   1800
         TabIndex        =   15
         Top             =   240
         Width           =   1695
      End
      Begin VB.CommandButton cmdConnectGW 
         Caption         =   "Connect Gateway"
         Height          =   375
         Left            =   120
         TabIndex        =   14
         Top             =   240
         Width           =   1695
      End
   End
   Begin VB.Frame frameAdmin 
      BackColor       =   &H00C0FFFF&
      Caption         =   "Administrative Messages"
      Height          =   1095
      Left            =   7680
      TabIndex        =   9
      Top             =   7920
      Width           =   3615
      Begin VB.CommandButton cmdTest 
         Caption         =   "Send Test Request"
         Height          =   375
         Left            =   1800
         TabIndex        =   12
         Top             =   240
         Width           =   1695
      End
      Begin VB.CommandButton cmdLogout 
         Caption         =   "Send Logout"
         Height          =   375
         Left            =   120
         TabIndex        =   11
         Top             =   600
         Width           =   1695
      End
      Begin VB.CommandButton cmdLogon 
         Caption         =   "Send Logon"
         Height          =   375
         Left            =   120
         TabIndex        =   10
         Top             =   240
         Width           =   1695
      End
   End
   Begin VB.Frame frameApp 
      BackColor       =   &H00C0FFFF&
      Caption         =   "Application Messages"
      Height          =   1095
      Left            =   11520
      TabIndex        =   5
      Top             =   7920
      Width           =   3615
      Begin VB.CommandButton cmdAmend 
         Caption         =   "Send Amend"
         Height          =   375
         Left            =   120
         TabIndex        =   8
         Top             =   600
         Width           =   1695
      End
      Begin VB.CommandButton cmdCancel 
         Caption         =   "Send Cancel"
         Height          =   375
         Left            =   1800
         TabIndex        =   7
         Top             =   240
         Width           =   1695
      End
      Begin VB.CommandButton cmdNew 
         Caption         =   "Send New Order"
         Height          =   375
         Left            =   120
         TabIndex        =   6
         Top             =   240
         Width           =   1695
      End
   End
   Begin MSComctlLib.StatusBar StatusBar1 
      Align           =   2  'Align Bottom
      Height          =   375
      Left            =   0
      TabIndex        =   4
      Top             =   9060
      Width           =   11400
      _ExtentX        =   20108
      _ExtentY        =   661
      _Version        =   393216
      BeginProperty Panels {8E3867A5-8586-11D1-B16A-00C0F0283628} 
         NumPanels       =   1
         BeginProperty Panel1 {8E3867AB-8586-11D1-B16A-00C0F0283628} 
         EndProperty
      EndProperty
   End
   Begin VB.ListBox List1 
      BackColor       =   &H00C0C0C0&
      Height          =   1620
      Left            =   0
      TabIndex        =   3
      Top             =   9120
      Width           =   15255
   End
   Begin VB.TextBox ConsoleFooter 
      Appearance      =   0  'Flat
      BackColor       =   &H00000000&
      Enabled         =   0   'False
      BeginProperty Font 
         Name            =   "Terminal"
         Size            =   9
         Charset         =   255
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00E0E0E0&
      Height          =   270
      Left            =   0
      TabIndex        =   2
      Top             =   7560
      Width           =   15135
   End
   Begin VB.TextBox ConsoleHeader 
      BackColor       =   &H00000000&
      BorderStyle     =   0  'None
      Enabled         =   0   'False
      BeginProperty Font 
         Name            =   "Terminal"
         Size            =   9
         Charset         =   255
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00E0E0E0&
      Height          =   375
      Left            =   0
      TabIndex        =   1
      Text            =   "Text2"
      Top             =   0
      Width           =   15135
   End
   Begin VB.ListBox HostConsole 
      Appearance      =   0  'Flat
      BackColor       =   &H00000000&
      Enabled         =   0   'False
      BeginProperty Font 
         Name            =   "Terminal"
         Size            =   6
         Charset         =   255
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00E0E0E0&
      Height          =   7230
      Left            =   0
      TabIndex        =   0
      Top             =   360
      Width           =   15135
   End
   Begin MSWinsockLib.Winsock SNASocket 
      Left            =   9720
      Top             =   7560
      _ExtentX        =   741
      _ExtentY        =   741
      _Version        =   393216
      RemoteHost      =   "127.0.0.1"
      RemotePort      =   12000
   End
   Begin MSWinsockLib.Winsock Winsock1 
      Left            =   0
      Top             =   0
      _ExtentX        =   741
      _ExtentY        =   741
      _Version        =   393216
      RemoteHost      =   "127.0.0.1"
      RemotePort      =   12000
   End
   Begin VB.Menu menuFile 
      Caption         =   "File"
      Begin VB.Menu menuExit 
         Caption         =   "Exit"
      End
   End
   Begin VB.Menu menuEdit 
      Caption         =   "Edit"
      Begin VB.Menu menuConfiguration 
         Caption         =   "Configuration"
      End
      Begin VB.Menu menuProperties 
         Caption         =   "Properties"
      End
   End
   Begin VB.Menu menuAdministration 
      Caption         =   "Administration"
      Begin VB.Menu menuConnectGateway 
         Caption         =   "Connect Gateway"
      End
      Begin VB.Menu menuLogon 
         Caption         =   "Send Logon"
      End
      Begin VB.Menu menuLogout 
         Caption         =   "Send Logout"
      End
      Begin VB.Menu menuTestConnection 
         Caption         =   "Send TestConnection"
      End
      Begin VB.Menu menuOperator 
         Caption         =   "Operator"
      End
      Begin VB.Menu menuGateway 
         Caption         =   "Gateway"
      End
      Begin VB.Menu menuMessages 
         Caption         =   "Messages"
      End
   End
   Begin VB.Menu menuHelp 
      Caption         =   "Help"
      Begin VB.Menu menuHelpTopic 
         Caption         =   "Help"
      End
      Begin VB.Menu menuAbout 
         Caption         =   "About"
      End
   End
End
Attribute VB_Name = "formMain"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim first As Boolean


Private Sub cmdConnect_Click()

End Sub

Private Sub Command1_Click()
 sendMessage ("LN120TRADIA20030830-22:27:34GOLD0")
 'Valores de LN: (tipo:intervaloHB:sender:date:target:encrypt)
 'sendMessage ("A GOLDMANS000000123CFR0000120271EN001000M000000123.1000002002/11/0200000000120:00:00EUR3001456721")
 'sendMessage ("A GOLDMANS000000000123CES0000000012EUR0000000000000999M000000023.25000520030212-13:05:00EUR20381118663000133445E1SI ")
 'Este es el bueno para probar nuevas ordenes
End Sub

Private Sub Command2_Click()
 sendMessage ("A GOLDMANS000000000123CES0000000012EUR0000000000000999M000000023.25000520030212-13:05:00EUR20381118663000133445E1SI ")
 'ver lo del campo texto
End Sub

Private Sub Command3_Click()
sendMessage ("B GOLDMANS000000001234000000000123CES0394857TYR999999XT000000009")

End Sub

Private Sub Command4_Click()
sendMessage ("M GOLDMANS000000000999000000000123CES0000000012EUR0000000000000999M000000023.25000520030212-13:05:00EUR20381118663000133445E1SI ")
End Sub

Private Sub Command6_Click()
 startSNASession
End Sub

Private Sub cmdAmend_Click()

 formCancelAmend.Show

End Sub

Private Sub cmdCancel_Click()

  formCancelAmend.Show
  
End Sub

Private Sub cmdMessage_Click()

' Dim MQ As MSMQConnection
' Set MQ = New MSMQConnection
 
 'MQ.connect
  
'Call formMessaging.setTransport(rv)
 formMessaging2.Show
 

End Sub

Private Sub cmdNew_Click()
  
  formSendNew.Show
  

End Sub

Private Sub Form_Load()
 
 setUpEnvironment
 first = True
 
 ' startSNASession
 
End Sub

Private Sub startSNASession()

 SNASocket.connect
 HostConsole.AddItem ("Client connected at LU001")
 HostConsole.AddItem ("Waiting to start conversation")
 
End Sub

Private Sub closeSNASession()

 SNASocket.Close

End Sub

Private Sub sendMessage(message As String)
 
 If SNASocket.State = sckClosed Then
  SNASocket.connect
'
 Else
  writeConsole ("SNA conversation started in LU001")
  SNASocket.SendData message & vbCrLf
  writeConsole ("Message written-->" & message)
  writeConsole ("SNA conversation closed")
  
 
 ' closeSNASession
  
  
 End If
 
End Sub

Private Sub setUpEnvironment()

 ConsoleHeader.Text = "SNA CONSOLE LOG"
 ConsoleFooter.Text = "SOMEBIZ BANK HOST"

End Sub

Private Sub writeConsole(msg As String)

 HostConsole.AddItem (msg)

End Sub


Private Sub SNASocket_DataArrival(ByVal bytesTotal As Long)
 
 Dim recibido As String
 
 SNASocket.GetData recibido, vbString
 
 List1.AddItem (recibido)
 
 'Text2.Text = recibido
 

End Sub

Private Sub SNASocket_Error(ByVal Number As Integer, Description As String, ByVal Scode As Long, ByVal Source As String, ByVal HelpFile As String, ByVal HelpContext As Long, CancelDisplay As Boolean)

 MsgBox Description
 End

End Sub

