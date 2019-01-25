VERSION 5.00
Begin VB.Form formSendNew 
   BorderStyle     =   1  'Fixed Single
   Caption         =   "Send New Order"
   ClientHeight    =   4860
   ClientLeft      =   5460
   ClientTop       =   3645
   ClientWidth     =   4530
   LinkTopic       =   "Form2"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   4860
   ScaleWidth      =   4530
   Begin VB.CommandButton cmdClean 
      Caption         =   "Clean Fields"
      Height          =   375
      Left            =   3000
      TabIndex        =   24
      Top             =   4320
      Width           =   1455
   End
   Begin VB.CommandButton cmdCancel 
      Caption         =   "Cancel"
      Height          =   375
      Left            =   1560
      TabIndex        =   23
      Top             =   4320
      Width           =   1455
   End
   Begin VB.TextBox txtText 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1440
      TabIndex        =   22
      Top             =   3840
      Width           =   2535
   End
   Begin VB.TextBox txtOrderType 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1440
      TabIndex        =   20
      Top             =   3480
      Width           =   2535
   End
   Begin VB.TextBox txtAccount 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1440
      TabIndex        =   18
      Top             =   3120
      Width           =   2535
   End
   Begin VB.TextBox txtCurrency 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1440
      TabIndex        =   16
      Top             =   2760
      Width           =   2535
   End
   Begin VB.TextBox txtDate 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1440
      TabIndex        =   14
      Top             =   2400
      Width           =   2535
   End
   Begin VB.TextBox txtAmount 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1440
      TabIndex        =   12
      Top             =   2040
      Width           =   2535
   End
   Begin VB.TextBox txtPrice 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1440
      TabIndex        =   10
      Top             =   1680
      Width           =   2535
   End
   Begin VB.TextBox txtISIN 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1440
      TabIndex        =   8
      Top             =   1320
      Width           =   2535
   End
   Begin VB.TextBox txtOrderID 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1440
      TabIndex        =   6
      Top             =   960
      Width           =   2535
   End
   Begin VB.TextBox txtBroker 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1440
      TabIndex        =   4
      Top             =   600
      Width           =   2535
   End
   Begin VB.TextBox txtMessageType 
      BorderStyle     =   0  'None
      Enabled         =   0   'False
      Height          =   285
      Left            =   1440
      TabIndex        =   2
      Top             =   240
      Width           =   2535
   End
   Begin VB.CommandButton cmdSend 
      Caption         =   "Send"
      Height          =   375
      Left            =   120
      TabIndex        =   0
      Top             =   4320
      Width           =   1455
   End
   Begin VB.Label labelText 
      Caption         =   "Text:"
      Height          =   255
      Left            =   360
      TabIndex        =   21
      Top             =   3840
      Width           =   855
   End
   Begin VB.Label labelOrderType 
      Caption         =   "Order type:"
      Height          =   255
      Left            =   360
      TabIndex        =   19
      Top             =   3480
      Width           =   855
   End
   Begin VB.Label labelAccount 
      Caption         =   "Account:"
      Height          =   255
      Left            =   360
      TabIndex        =   17
      Top             =   3120
      Width           =   855
   End
   Begin VB.Label labelCurrency 
      Caption         =   "Currency:"
      Height          =   255
      Left            =   360
      TabIndex        =   15
      Top             =   2760
      Width           =   855
   End
   Begin VB.Label labelDate 
      Caption         =   "Date:"
      Height          =   255
      Left            =   360
      TabIndex        =   13
      Top             =   2400
      Width           =   855
   End
   Begin VB.Label labelAmount 
      Caption         =   "Amount:"
      Height          =   255
      Left            =   360
      TabIndex        =   11
      Top             =   2040
      Width           =   855
   End
   Begin VB.Label labelPrice 
      Caption         =   "Price:"
      Height          =   255
      Left            =   360
      TabIndex        =   9
      Top             =   1680
      Width           =   855
   End
   Begin VB.Label labelISIN 
      Caption         =   "ISIN code:"
      Height          =   255
      Left            =   360
      TabIndex        =   7
      Top             =   1320
      Width           =   855
   End
   Begin VB.Label labelOrderID 
      Caption         =   "Order ID:"
      Height          =   255
      Left            =   360
      TabIndex        =   5
      Top             =   960
      Width           =   855
   End
   Begin VB.Label labelBroker 
      Caption         =   "Broker:"
      Height          =   255
      Left            =   360
      TabIndex        =   3
      Top             =   600
      Width           =   855
   End
   Begin VB.Label labelMessageType 
      Caption         =   "Message type:"
      Height          =   255
      Left            =   360
      TabIndex        =   1
      Top             =   240
      Width           =   1095
   End
End
Attribute VB_Name = "formSendNew"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()
Load Form1
Form1.Show
End Sub

