using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Intepro.DataAccess;       //Use DAL
using System.Data.SqlClient;    //Use SqlDataReader

namespace Intepro.BusinessLogic //Change to this namespace
{
    public class EmployeeModel
    {
        public long ID { get; set; }
        public string Lastname { get; set; }
        public string Firstname { get; set; }
        public DateTime DateHired { get; set; }
        public Decimal HourlyRate { get; set; }

        private DAL dl = new DAL();
        public void Add()
        {
            dl.Open();
            dl.SetSql("INSERT INTO Employees VALUES" +
                " (@ln, @fn, @dh, @hr)");
            dl.AddParam("@ln", Lastname);
            dl.AddParam("@fn", Firstname);
            dl.AddParam("@dh", DateHired);
            dl.AddParam("@hr", HourlyRate);
            dl.Execute();
            dl.Close();
        }
        public void Delete()
        {
            dl.Open();
            dl.SetSql("DELETE Employees WHERE EmployeeID = @eid");
            dl.AddParam("@eid", ID);
            dl.Execute();
            dl.Close();
        }
        public List<EmployeeModel> Get()
        {
            List<EmployeeModel> list =
                new List<EmployeeModel>();
            dl.Open();
            dl.SetSql("SELECT * FROM Employees");
            SqlDataReader dr = dl.GetReader();
            while (dr.Read() == true)
            {
                EmployeeModel emp = new EmployeeModel();
                emp.ID = (long)dr[0];
                emp.Lastname = dr[1].ToString();
                emp.Firstname = dr[2].ToString();
                emp.DateHired = (DateTime)dr[3];
                emp.HourlyRate = (Decimal)dr[4];
                list.Add(emp);
            }
            dr.Close();
            dl.Close();
            return list;
        }
        public EmployeeModel Get1Employee()
        {
            EmployeeModel obj = new EmployeeModel();
            dl.Open();
            dl.SetSql("SELECT * FROM Employees WHERE EmployeeID=@eid");
            dl.AddParam("@eid", ID);
            SqlDataReader dr = dl.GetReader();
            if (dr.Read() == true)
            {
                obj.ID = (long)dr[0];
                obj.Lastname = dr[1].ToString();
                obj.Firstname = dr[2].ToString();
                obj.DateHired = (DateTime)dr[3];
                obj.HourlyRate = (Decimal)dr[4];
            }
            dr.Close();
            dl.Close();
            return obj;
        }
        public void Update()
        {
            dl.Open();
            dl.SetSql("UPDATE Employees SET Lastname=@ln, Firstname=@fn," +
                "DateHired=@dh, HourlyRate=@hr WHERE EmployeeID=@eid");
            dl.AddParam("@ln", Lastname);
            dl.AddParam("@fn", Firstname);
            dl.AddParam("@dh", DateHired);
            dl.AddParam("@hr", HourlyRate);
            dl.AddParam("@eid", ID);
            dl.Execute();
            dl.Close();
        }
    }
}