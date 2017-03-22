using System.Diagnostics.Contracts;

namespace Innopolis_Univwrsity_IS.University_IS
{
    class Group
    {
        int id;
        private string name;
        private Students groupStudents;
        private Department groupDepartment;
        private Subjects groupSubjects;

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

        internal Students GroupStudents
        {
            get
            {
                return groupStudents;
            }

            set
            {
                Contract.Assert(value != null, "Set the correct Students");
                groupStudents = value;
            }
        }

        internal Department GroupDepartment
        {
            get
            {
                return groupDepartment;
            }

            set
            {
                Contract.Assert(value != null, "Set the correct Department");
                groupDepartment = value;
            }
        }

        internal Subjects GroupSubjects
        {
            get
            {
                return groupSubjects;
            }

            set
            {
                Contract.Assert(value != null, "Set the correct Subjects");
                groupSubjects = value;
            }
        }

        public Group(string name, int id)
        {
            Contract.Assert(name != null, "Enter the correct Name");
            this.Name = name;
            this.id = id;
            GroupDepartment = new Department();
            GroupStudents = new Students();
            GroupSubjects = new Subjects();
            Contract.Ensures(id >= 0, "ID is less than 0!");
        }

        public Group()
        {

        }




        

    }
}
