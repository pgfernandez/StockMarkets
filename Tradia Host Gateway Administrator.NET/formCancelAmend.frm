VERSION 5.00
Begin VB.Form formCancelAmend 
   BorderStyle     =   1  'Fixed Single
   ClientHeight    =   5070
   ClientLeft      =   45
   ClientTop       =   330
   ClientWidth     =   4845
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   5070
   ScaleWidth      =   4845
   StartUpPosition =   2  'CenterScreen
   Begin VB.TextBox txtClOrderID 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1560
      TabIndex        =   26
      Top             =   1320
      Width           =   2535
   End
   Begin VB.CommandButton cmdSend 
      Caption         =   "Send"
      Height          =   375
      Left            =   240
      TabIndex        =   13
      Top             =   4560
      Width           =   1455
   End
   Begin VB.TextBox txtMessageType 
      BorderStyle     =   0  'None
      Enabled         =   0   'False
      Height          =   285
      Left            =   1560
      TabIndex        =   12
      Top             =   240
      Width           =   2535
   End
   Begin VB.TextBox txtBroker 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1560
      TabIndex        =   11
      Top             =   600
      Width           =   2535
   End
   Begin VB.TextBox txtOrderID 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1560
      TabIndex        =   10
      Top             =   960
      Width           =   2535
   End
   Begin VB.TextBox txtISIN 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1560
      TabIndex        =   9
      Top             =   1680
      Width           =   2535
   End
   Begin VB.TextBox txtPrice 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1560
      TabIndex        =   8
      Top             =   2040
      Width           =   2535
   End
   Begin VB.TextBox txtAmount 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1560
      TabIndex        =   7
      Top             =   2400
      Width           =   2535
   End
   Begin VB.TextBox txtDate 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1560
      TabIndex        =   6
      Top             =   2760
      Width           =   2535
   End
   Begin VB.TextBox txtCurrency 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1560
      TabIndex        =   5
      Top             =   3120
      Width           =   2535
   End
   Begin VB.TextBox txtAccount 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1560
      TabIndex        =   4
      Top             =   3480
      Width           =   2535
   End
   Begin VB.TextBox txtOrderType 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1560
      TabIndex        =   3
      Top             =   3840
      Width           =   2535
   End
   Begin VB.TextBox txtText 
      BorderStyle     =   0  'None
      Height          =   285
      Left            =   1560
      TabIndex        =   2
      Top             =   4200
      Width           =   2535
   End
   Begin VB.CommandButton cmdCancel 
      Caption         =   "Cancel"
      Height          =   375
      Left            =   1680
      TabIndex        =   1
      Top             =   4560
      Width           =   1455
   End
   Begin VB.CommandButton cmdClean 
      Caption         =   "Clean Fields"
      Height          =   375
      Left            =   3120
      TabIndex        =   0
      Top             =   4560
      Width           =   1455
   End
   Begin VB.Label labelClOrderID 
      Height          =   255
      Left            =   480
      TabIndex        =   25
      Top             =   1320
      Width           =   855
   End
   Begin VB.Label labelMessageType 
      Caption         =   "Message type:"
      Height          =   255
      Left            =   480
      TabIndex        =   24
      Top             =   240
      Width           =   1095
   End
   Begin VB.Label labelBroker 
      Caption         =   "Broker:"
      Height          =   255
      Left            =   480
      TabIndex        =   23
      Top             =   600
      Width           =   855
   End
   Begin VB.Label labelOrderID 
      Caption         =   "Order ID:"
      Height          =   255
      Left            =   480
      TabIndex        =   22
      Top             =   960
      Width           =   855
   End
   Begin VB.Label labelISIN 
      Caption         =   "ISIN code:"
      Height          =   255
      Left            =   480
      TabIndex        =   21
      Top             =   1680
      Width           =   855
   End
   Begin VB.Label labelPrice 
      Caption         =   "Price:"
      Height          =   255
      Left            =   480
      TabIndex        =   20
      Top             =   2040
      Width           =   855
   End
   Begin VB.Label labelAmount 
      Caption         =   "Amount:"
      Height          =   255
      Left            =   480
      TabIndex        =   19
      Top             =   2400
      Width           =   855
   End
   Begin VB.Label labelDate 
      Caption         =   "Date:"
      Height          =   255
      Left            =   480
      TabIndex        =   18
      Top             =   2760
      Width           =   855
   End
   Begin VB.Label labelCurrency 
      Caption         =   "Currency:"
      Height          =   255
      Left            =   480
      TabIndex        =   17
      Top             =   3120
      Width           =   855
   End
   Begin VB.Label labelAccount 
      Caption         =   "Account:"
      Height          =   255
      Left            =   480
      TabIndex        =   16
      Top             =   3480
      Width           =   855
   End
   Begin VB.Label labelOrderType 
      Caption         =   "Order type:"
      Height          =   255
      Left            =   480
      TabIndex        =   15
      Top             =   3840
      Width           =   855
   End
   Begin VB.Label labelText 
      Caption         =   "Text:"
      Height          =   255
      Left            =   480
      TabIndex        =   14
      Top             =   4200
      Width           =   855
   End
End
Attribute VB_Name = "formCancelAmend"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
