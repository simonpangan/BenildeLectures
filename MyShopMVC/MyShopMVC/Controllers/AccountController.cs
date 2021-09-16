using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

using System.Data;
using System.Data.SqlClient;

using MyShopMVC.Models;
using MyShopMVC.App_Code;

namespace MyShopMVC.Controllers
{
    public class AccountController : Controller
    {
        public ActionResult Register()
        {
            return View();
        }

        bool IsExisting(string email)
        {
            using (SqlConnection con = new SqlConnection(Helper.GetCon()))
            {
                con.Open();
                string query = @"SELECT Email FROM Users
                    WHERE Email=@Email";
                using (SqlCommand cmd = new SqlCommand(query, con))
                {
                    cmd.Parameters.AddWithValue("@Email", email);
                    return cmd.ExecuteScalar() == null ? false : true;
                }
            }
        }

        [HttpPost]
        public ActionResult Register(UsersModel record)
        {
            if (IsExisting(record.Email))
            {
                ViewBag.Error = "<div class='alert alert-danger col-lg-5'>Email already existing.</div>";
                return View(record);
            }
            else
            {
                using (SqlConnection con = new SqlConnection(Helper.GetCon()))
                {
                    con.Open();
                    string query = @"INSERT INTO Users VALUES
                    (@TypeID, @Email, @Password, 
                    @FirstName, @LastName,
                    @Street, @Municipality, @City,
                    @Phone, @Mobile, @Status,
                    @DateAdded, @DateModified)";
                    using (SqlCommand cmd = new SqlCommand(query, con))
                    {
                        cmd.Parameters.AddWithValue("@TypeID", 2); // Customer
                        cmd.Parameters.AddWithValue("@Email", record.Email);
                        cmd.Parameters.AddWithValue("@Password", Helper.Hash(record.Password));
                        cmd.Parameters.AddWithValue("@FirstName", record.FN);
                        cmd.Parameters.AddWithValue("@LastName", record.LN);
                        cmd.Parameters.AddWithValue("@Street", "");
                        cmd.Parameters.AddWithValue("@Municipality", "");
                        cmd.Parameters.AddWithValue("@City", "");
                        cmd.Parameters.AddWithValue("@Phone", "");
                        cmd.Parameters.AddWithValue("@Mobile", DBNull.Value);
                        cmd.Parameters.AddWithValue("@Status", "Active");
                        cmd.Parameters.AddWithValue("@DateAdded", DateTime.Now);
                        cmd.Parameters.AddWithValue("@DateModified", DBNull.Value);
                        cmd.ExecuteNonQuery();

                        Helper.Log("Add", "Added a user.");

                        string message = "Hello, " + record.FN + " " + record.LN + "!<br/><br/>" +
                            "You have successfully created an account.<br/>" +
                            "Thank you.<br/><br/>" +
                            "Regards,<br/>" +
                            "The Administrator";

                        Helper.SendEmail(record.Email, "Account Registration", message);
                        return RedirectToAction("Login");
                    }
                }
            }
        }

        public ActionResult Login()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Login(UsersModel record)
        {
            using (SqlConnection con = new SqlConnection(Helper.GetCon()))
            {
                con.Open();
                string query = @"SELECT UserID, TypeID FROM Users
                    WHERE Email=@Email AND Password=@Password";
                using (SqlCommand cmd = new SqlCommand(query, con))
                {
                    cmd.Parameters.AddWithValue("@Email", record.Email);
                    cmd.Parameters.AddWithValue("@Password", Helper.Hash(record.Password));
                    using (SqlDataReader data = cmd.ExecuteReader())
                    {
                        if (data.HasRows)
                        {
                            while (data.Read())
                            {
                                Session["userid"] = data["UserID"].ToString();
                                Session["typeid"] = data["TypeID"].ToString();
                            }
                            return RedirectToAction("MyProfile");
                        }
                        else
                        {
                            ViewBag.Error = "<div class='alert alert-danger col-lg-5'>Invalid email or password.</div>";
                            return View(record);
                        }
                    }
                }
            }
        }
    }
}