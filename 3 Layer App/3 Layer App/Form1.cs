using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Intepro.BusinessLogic;    //Use ParticipantBLL

namespace _3_Layer_App
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        private ParticipantBLL par = new ParticipantBLL();
        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                par.ID = long.Parse(txtID.Text);
                par.Lastname = txtLN.Text;
                par.Firstname = txtFN.Text;
                par.CheckRules();
                par.Add();

                MessageBox.Show("Add Successful!");
                txtID.Clear(); txtLN.Clear(); txtFN.Clear();
                dgvP.DataSource = par.List();
                txtID.Select();
            }
            catch (Exception ex)
            {
                //MessageBox.Show(ex.Message, ex.Source);
                txtError.Text = ex.Message;
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            dgvP.DataSource = par.List();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            dgvP.DataSource = par.List();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            try
            {
                //par.ID = long.Parse(txtID.Text);
                //par.ID = long.Parse(dgvP.SelectedRows[0].Cells[0]
                //    .Value.ToString());
                par.ID = (long)dgvP.SelectedRows[0].Cells[0].Value;
                par.Delete();

                MessageBox.Show("Delete Successful!");
                txtID.Clear(); txtLN.Clear(); txtFN.Clear();
                dgvP.DataSource = par.List(); txtID.Select();
            }
            catch (Exception ex)
            {
                txtError.Text = ex.Message;
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            try
            {
                par.ID = long.Parse(txtID.Text);
                par.Lastname = txtLN.Text;
                par.Firstname = txtFN.Text;
                long oid = (long)dgvP.SelectedRows[0].Cells[0].Value;
                par.Update(oid);

                MessageBox.Show("Update Successful!");
                txtID.Clear(); txtLN.Clear(); txtFN.Clear();
                dgvP.DataSource = par.List(); txtID.Select();
            }
            catch (Exception ex)
            {
                txtError.Text = ex.Message;
            }
        }

        private void dgvP_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            txtID.Text = dgvP.SelectedRows[0].Cells[0].Value.ToString();
            txtLN.Text = dgvP.SelectedRows[0].Cells[1].Value.ToString();
            txtFN.Text = dgvP.SelectedRows[0].Cells[2].Value.ToString();
        }
    }
}
