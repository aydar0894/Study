using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Innopolis_Univwrsity_IS.University_IS
{
    class Lab
    {
        private int id;
        private string name;
        private Department labDepartment;
        private Professor labProfessor;
        private Students labStudents;

        public int Id
        {
            get
            {
                return id;
            }

            set
            {
                id = value;
            }
        }

        public string Name
        {
            get
            {
                return name;
            }

            set
            {
                name = value;
            }
        }

        internal Department LabDepartment
        {
            get
            {
                return labDepartment;
            }

            set
            {
                labDepartment = value;
            }
        }

        internal Professor LabProfessor
        {
            get
            {
                return labProfessor;
            }

            set
            {
                labProfessor = value;
            }
        }

        internal Students LabStudents
        {
            get
            {
                return labStudents;
            }

            set
            {
                labStudents = value;
            }
        }

        public Lab(string name, int count)
        {
            this.Name = name;
            this.Id = count;
            LabDepartment = new Department();
            LabProfessor = new Professor();
            LabStudents = new Students();
        }
    }
}
