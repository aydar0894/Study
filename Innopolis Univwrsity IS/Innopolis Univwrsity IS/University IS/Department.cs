using System.Diagnostics.Contracts;


namespace Innopolis_Univwrsity_IS.University_IS
{
    class Department
    {
        private int id;
        private string name;
        private Groups deptGroups;
        private Professors deptProfessors;
        private Subjects deptSubjects;

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
                Contract.Assert(value != null, "Set the correct Name");
                name = value;
            }
        }

        internal Groups DeptGroups
        {
            get
            {
                return deptGroups;
            }

            set
            {
                Contract.Assert(value != null, "Set the correct Groups");
                deptGroups = value;
            }
        }

        internal Professors DeptProfessors
        {
            get
            {
                return deptProfessors;
            }

            set
            {
               // Contract.Assert(value != null, "Set the correct Professors");
                deptProfessors = value;
            }
        }

        internal Subjects DeptSubjects
        {
            get
            {
                return deptSubjects;
            }

            set
            {
                Contract.Assert(value != null, "Set the correct Subjects");
                deptSubjects = value;
            }
        }

        public Department(string aName,int count)
        {
            Contract.Assert(aName != null, "Enter the correct Name");
            Id = count;
            Name = aName;
            DeptGroups = new Groups();
            DeptProfessors = new Professors();
            DeptSubjects = new Subjects();
            
        } 
        public Department()
        {

        }

        

    }
}
