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
    public class ProductsController : Controller
    {
        public List<CategoriesModel> GetCategories()
        {
            var list = new List<CategoriesModel>();
            using (SqlConnection con = new SqlConnection(Helper.GetCon()))
            {
                con.Open();
                string query = @"SELECT CatID, Category FROM Categories
                    ORDER BY Category";
                using (SqlCommand cmd = new SqlCommand(query, con))
                {
                    using (SqlDataReader data = cmd.ExecuteReader())
                    {
                        while (data.Read())
                        {
                            list.Add(new CategoriesModel
                            {
                                CatID = int.Parse(data["CatID"].ToString()),
                                Category = data["Category"].ToString()
                            });
                        }
                        return list;
                    }
                }
            }
        }

        public ActionResult Add()
        {
            var record = new ProductsModel();
            record.Categories = GetCategories();
            return View(record);
        }

        [HttpPost]
        public ActionResult Add(ProductsModel record, HttpPostedFileBase image)
        {
            using (SqlConnection con = new SqlConnection(Helper.GetCon()))
            {
                con.Open();
                string query = @"INSERT INTO products VALUES
                    (@Name, @CatID, @Code, @Description,
                    @Image, @Price, @IsFeatured, @Available,
                    @Critical, @Maximum, @Status, @DateAdded, @DateModified)";
                using (SqlCommand cmd = new SqlCommand(query, con))
                {
                    cmd.Parameters.AddWithValue("@Name", record.Name);
                    cmd.Parameters.AddWithValue("@CatID", record.CatID);
                    cmd.Parameters.AddWithValue("@Code", record.Code);
                    cmd.Parameters.AddWithValue("@Description", record.Description);
                    cmd.Parameters.AddWithValue("@Image",
                        DateTime.Now.ToString("yyyyMMddHHmmss-") + image.FileName);
                    image.SaveAs(Server.MapPath("~/Images/Products/" +
                        DateTime.Now.ToString("yyyyMMddHHmmss-") + image.FileName));
                    cmd.Parameters.AddWithValue("@Price", record.Price);
                    cmd.Parameters.AddWithValue("@IsFeatured", record.IsFeatured ? "Yes" : "No");
                    cmd.Parameters.AddWithValue("@Available", 100);
                    cmd.Parameters.AddWithValue("@Critical", record.Critical);
                    cmd.Parameters.AddWithValue("@Maximum", record.Maximum);
                    cmd.Parameters.AddWithValue("@Status", "Active");
                    cmd.Parameters.AddWithValue("@DateAdded", DateTime.Now);
                    cmd.Parameters.AddWithValue("@DateModified", DBNull.Value);
                    cmd.ExecuteNonQuery();
                    Helper.Log("Add", "Added a product record");

                    return RedirectToAction("Index");
                }
            }
        }

        // GET: Products
        public ActionResult Index()
        {
            return View();
        }
    }
}