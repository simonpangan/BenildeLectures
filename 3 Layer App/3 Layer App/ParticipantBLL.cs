using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Intepro.DataAccess;       //Use DAL
using System.Data;              //Use DataTable

namespace Intepro.BusinessLogic
{
    class ParticipantBLL
    {
        #region SQL Server - C# Data Type Mapping
        //smallint = short
        //tinyint = byte
        //datetime = DateTime
        //real = float
        //float = double
        //numeric(18, 0) = decimal
        //decimal(18, 0) = Decimal
        #endregion

        private DAL dl = new DAL();
        //BigInt = long
        //public long ID;
        public long ID { get; set; }
        //char, nchar, varchar, nvarchar, text, ntext = string
        public string Lastname { get; set; }
        public string Firstname { get; set; }
        public void Add()
        {
            dl.Open();
            dl.SetSql(
                "INSERT INTO Participants VALUES (@id, @ln, @fn)");
            dl.AddParam("@id", ID);
            dl.AddParam("@ln", Lastname);
            dl.AddParam("@fn", Firstname);
            dl.Execute();
            dl.Close();
        }
        public void CheckRules()
        {
            //1.) ID must be a 8-digit number
            if (ID < 10000000 || ID > 99999999)
            {
                Exception a = new Exception(
                    "ID must be 8-digit numbers!");
                a.Source = "Participant BLL - CheckRules";
                throw a;
            }
            //2.) Lastname must be at least 2 characters
            //3.) Lastname must be at most 50 characters
            if (Lastname.Length < 2 || Lastname.Length > 50)
            {
                Exception b = new Exception(
                    "Lastname must have 2 to 50 chars only");
                b.Source = "Participant BLL - CheckRules";
                throw b;
            }
            //4.) Lastname must not be a number
            int num;
            bool isNum = int.TryParse(Lastname, out num);
            if (isNum == true)
            {   //Last name is a number!!! Cannot be!
                Exception c = new Exception(
                    "Lastname cannot be a number");
                c.Source = "Participant BLL - CheckRules";
                throw c;
            }
            //5.) Firstname must be at least 5 characters
            //6.) Firstname must be at most 50 characters
            if (Firstname.Length < 5 || Firstname.Length > 50)
            {
                Exception d = new Exception(
                    "Firstname must have 5 to 50 chars only");
                d.Source = "Participant BLL - CheckRules";
                throw d;
            }
            //7.) Firstname must not be a number
            double num2;
            isNum = double.TryParse(Firstname, out num2);
            if (isNum ==  true)
            {   //Firstname is a number!!! Cannot be!
                Exception e = new Exception(
                    "Firstname cannot be a number");
                e.Source = "Participant BLL - CheckRules";
                throw e;
            }
        }
        public void Delete()
        {
            dl.Open();
            dl.SetSql("DELETE Participants WHERE ID = @id");
            dl.AddParam("@id", ID);
            dl.Execute();
            dl.Close();
        }
        public DataTable List()
        {
            dl.Open();
            dl.SetSql("SELECT * FROM Participants");
            DataTable dt = dl.GetRecords();
            dl.Close();

            return dt;
        }
        public void Update(long oldID)
        {
            dl.Open();
            dl.SetSql("UPDATE Participants SET ID = @id," +
                "Lastname = @ln," +
                "Firstname = @fn WHERE ID = @oldID");
            dl.AddParam("@id", ID);
            dl.AddParam("@ln", Lastname);
            dl.AddParam("@fn", Firstname);
            dl.AddParam("@oldID", oldID);
            dl.Execute();
            dl.Close();
        }
    }
}
