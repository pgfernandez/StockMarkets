VERSION 5.00
Begin VB.Form formMessaging2 
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
      Height          =   495
      Left            =   960
      TabIndex        =   0
      Top             =   1680
      Width           =   2295
   End
End
Attribute VB_Name = "formMessaging2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Private msmqConnection As MsmqConnectorX.CMSMQConnector

Private Sub Command1_Click()

msmqConnection.connect


End Sub

Private Sub Form_Load()
Set msmqConnection = New CMSMQConnector




End Sub
