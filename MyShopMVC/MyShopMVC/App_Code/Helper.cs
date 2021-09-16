using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

using System.Configuration;
using System.Net.Mail;
using System.Security.Cryptography;

using System.Data;
using System.Data.SqlClient;

namespace MyShopMVC.App_Code
{
    public class Helper
    {
        public static string GetCon()
        {
            return ConfigurationManager.ConnectionStrings["MyCon"].ConnectionString;
        }

        public static void SendEmail(string email, string subject, string message)
        {
            MailMessage emailMessage = new MailMessage();
            emailMessage.From = new MailAddress("benilde.web.development@gmail.com", "no-reply");
            emailMessage.To.Add(new MailAddress(email));
            emailMessage.Subject = subject;
            emailMessage.Body = message;
            emailMessage.IsBodyHtml = true;
            emailMessage.Priority = MailPriority.Normal;
            SmtpClient MailClient = new SmtpClient("smtp.gmail.com", 587);
            MailClient.EnableSsl = true;
            MailClient.Credentials = new System.Net.NetworkCredential("benilde.web.development@gmail.com", "!thisisalongpassword1234567890");
            MailClient.Send(emailMessage);
        }

        /// <summary>
        /// Returns a hash value using a secured hash algorithm (SHA-2)
        /// </summary>
        public static string Hash(string phrase)
        {
            SHA512Managed HashTool = new SHA512Managed();
            Byte[] PhraseAsByte = System.Text.Encoding.UTF8.GetBytes(string.Concat(phrase));
            Byte[] EncryptedBytes = HashTool.ComputeHash(PhraseAsByte);
            HashTool.Clear();
            return Convert.ToBase64String(EncryptedBytes);
        }

        /// <summary>
        /// Creates an audit log record based from user's activity and description
        /// </summary>
        /// <param name="type">e.g Login, Logout, Add, Update, Error</param>
        /// <param name="description">e.g. Logged in successfully, Added user.</param>
        public static void Log(string type, string description)
        {
            using (SqlConnection con = new SqlConnection(GetCon()))
            {
                con.Open();
                string query = @"INSERT INTO Logs VALUES
                    (@UserID, @LogType, @Description, @Timestamp);";
                using (SqlCommand cmd = new SqlCommand(query, con))
                {
                    if (HttpContext.Current.Session["userid"] == null)
                        cmd.Parameters.AddWithValue("@UserID", 0);
                    else
                        cmd.Parameters.AddWithValue("@UserID",
                            HttpContext.Current.Session["userid"].ToString());
                    cmd.Parameters.AddWithValue("@LogType", type);
                    cmd.Parameters.AddWithValue("@Description", description);
                    cmd.Parameters.AddWithValue("@Timestamp", DateTime.Now);
                    cmd.ExecuteNonQuery();
                }
            }
        }
    }
}