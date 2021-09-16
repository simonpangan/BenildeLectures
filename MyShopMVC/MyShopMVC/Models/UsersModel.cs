using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

using System.ComponentModel.DataAnnotations;

namespace MyShopMVC.Models
{
    public class UsersModel
    {
        [Key]
        public int ID { get; set; }

        [Display(Name = "User Type")]
        [Required(ErrorMessage = "Select from the list.")]
        public int TypeID { get; set; }

        public List<TypesModel> UserTypes { get; set; }
        public string UserType { get; set; }

        [Required(ErrorMessage = "Required.")]
        [MaxLength(100, ErrorMessage = "Invalid character length.")]
        [DataType(DataType.EmailAddress)]
        public string Email { get; set; }

        [Required(ErrorMessage = "Required.")]
        [DataType(DataType.Password)]
        public string Password { get; set; }

        [Display(Name = "First Name")]
        [Required(ErrorMessage = "Required.")]
        [MaxLength(80, ErrorMessage = "Invalid character length.")]
        public string FN { get; set; }

        [Display(Name = "Last Name")]
        [Required(ErrorMessage = "Required.")]
        [MaxLength(80, ErrorMessage = "Invalid character length.")]
        public string LN { get; set; }

        [MaxLength(50, ErrorMessage ="Invalid character length.")]
        public string Street { get; set; }

        [MaxLength(80, ErrorMessage = "Invalid character length.")]
        public string Municipality { get; set; }

        [MaxLength(50, ErrorMessage = "Invalid character length.")]
        public string City { get; set; }

        [MaxLength(12, ErrorMessage = "Invalid character length.")]
        public string Phone { get; set; }

        [RegularExpression(".{11,11}", ErrorMessage = "Incorrect format.")]
        public string Mobile { get; set; }

        public string Status { get; set; }

        [Display(Name ="Date Added")]
        public DateTime DateAdded { get; set; }

        [Display(Name ="Date Modified")]
        public DateTime? DateModified { get; set; }
    }

    public class TypesModel
    {
        public int TypeID { get; set; }
        public string UserType { get; set; }
    }
}