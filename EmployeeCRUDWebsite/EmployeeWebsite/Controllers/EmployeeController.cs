using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Intepro.BusinessLogic;        //Use EmployeeModel (BLL)

namespace EmployeeWebsite.Controllers
{
    public class EmployeeController : Controller
    {
        private EmployeeModel emp = new EmployeeModel();
        public ActionResult Index()
        {   //View all
            //emp.Get is our FastList
            return View(emp.Get());
        }

        public ActionResult Add()
        {   //Add employee (registration)
            return View();
        }
        [HttpPost]
        public ActionResult Delete(FormCollection form)
        {
            emp.ID = long.Parse(form["ID"]);
            emp.Delete();

            return RedirectToAction("Index");
        }
        public ActionResult Edit(long EmployeeID)
        {
            emp.ID = EmployeeID;

            return View(emp.Get1Employee());
        }
        [HttpPost]
        public ActionResult Save(FormCollection form)
        {
            emp.Lastname = form["Lastname"];
            emp.Firstname = form["Firstname"];
            emp.DateHired = DateTime.Parse(form["DateHired"]);
            emp.HourlyRate = Decimal.Parse(form["HourlyRate"]);
            emp.Add();

            return RedirectToAction("Index");
        }
        [HttpPost]
        public ActionResult Update(FormCollection form)
        {
            emp.ID = long.Parse(form["ID"]);
            emp.Lastname = form["Lastname"];
            emp.Firstname = form["Firstname"];
            emp.DateHired = DateTime.Parse(form["DateHired"]);
            emp.HourlyRate = Decimal.Parse(form["HourlyRate"]);
            emp.Update();

            return RedirectToAction("Index");
        }
    }
}