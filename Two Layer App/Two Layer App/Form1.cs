using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Intepro.DataAccess;   //Access to DAL

namespace Two_Layer_App
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        private DAL dl = new DAL();
        private void button1_Click(object sender, EventArgs e)
        {   //Add button
            dl.Open();
            dl.SetSql("INSERT INTO Participants " +
                " VALUES (@id, @ln, @fn)");
            dl.AddParam("@id", txtID.Text);
            dl.AddParam("@ln", txtLN.Text);
            dl.AddParam("@fn", txtFN.Text);
            dl.Execute();
            dl.Close();

            //MessageBox.Show("Add successful!");
            //txtID.Clear(); txtLN.Clear(); txtFN.Clear();
            //button4_Click(sender, e);
            Complete("Add Successful!", sender, e);
        }
        private void Complete(string message,
            object sender, EventArgs e)
        {
            MessageBox.Show(message);
            txtID.Clear(); txtLN.Clear(); txtFN.Clear();
            button4_Click(sender, e);
        }
        private void button4_Click(object sender, EventArgs e)
        {   //View all button
            dl.Open();
            dl.SetSql("SELECT * FROM Participants");
            dgvP.DataSource = dl.GetRecords();
            dl.Close();
        }

        private void dgvP_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            txtID.Text = dgvP.SelectedRows[0].Cells[0].Value.ToString();
            txtLN.Text = dgvP.SelectedRows[0].Cells[1].Value.ToString();
            txtFN.Text = dgvP.SelectedRows[0].Cells[2].Value.ToString();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            button4_Click(sender, e);
        }

        private void button2_Click(object sender, EventArgs e)
        {   //Edit button
            dl.Open();
            dl.SetSql("UPDATE Participants SET Lastname = @ln, " +
                "Firstname = @fn WHERE ID = @id");
            dl.AddParam("@ln", txtLN.Text);
            dl.AddParam("@fn", txtFN.Text);
            dl.AddParam("@id", txtID.Text);
            dl.Execute();
            dl.Close();

            Complete("Update succesful!", sender, e);
        }

        private void button3_Click(object sender, EventArgs e)
        {
            dl.Open();
            dl.SetSql("DELETE Participants WHERE ID = @id");
            dl.AddParam("@id",
                dgvP.SelectedRows[0].Cells[0].Value.ToString());
            dl.Execute();
            dl.Close();
            Complete("Delete successful!", sender, e);
        }
    }
}
