using System.Diagnostics.Contracts;

namespace Innopolis_Univwrsity_IS.University_IS
{
   unsafe class Subject
    {
        private int id;
        private string name;
        private Professor subjectInstructor;
        private Department subjectDepartment;

        internal Professor SubjectInstructor
        {
            get
            {
                return subjectInstructor;
            }

            set
            {
               // Contract.Assert(value != null, "Set the correct Professor");
                subjectInstructor = value;
            }
        }

        internal Department SubjectDepartment
        {
            get
            {
                return subjectDepartment;
            }

            set
            {
                Contract.Assert(value != null, "Set the correct Department");
                subjectDepartment = value;
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
                Contract.Assert(value != null, "Set the correct Name");
                name = value;
            }
        }

        public int Id
        {
            get
            {
                return id;
            }

            set
            {
                id = value;
                Contract.Ensures(id >= 0, "ID is less than 0!");
            }
        }

        public Subject(string name, int id)
        {
            
            Contract.Assert(name != null, "Enter the correct Name");
            this.Name = name;
            this.Id = id;
            SubjectDepartment = new Department();
            SubjectInstructor = new Professor();
            Contract.Ensures(id >= 0, "ID is less than 0!");
        }
       
                
    }
}
