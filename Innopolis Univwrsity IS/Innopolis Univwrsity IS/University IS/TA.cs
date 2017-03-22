
using System.Diagnostics.Contracts;

namespace Innopolis_Univwrsity_IS.University_IS
{
    class TA : Person

    {
        
        public Professor primaryInsrtuctor;
        public Department taDepartment;
        
        

        public TA(string name, int id)
        {
            Contract.Assert(name != null, "Enter the correct name");
            this.Name = name;
            this.Id = id;
            primaryInsrtuctor = new Professor();
            taDepartment = new Department();
            Contract.Ensures(id >= 0, "ID is less than 0!");
        }

        public TA(string name, Professor primaryIns, Department dept )
        {
            Contract.Assert(name != null && primaryIns!= null && dept!= null, "Enter the correct parameters");
            this.Name = name;
            this.primaryInsrtuctor = primaryIns;
            this.taDepartment = dept;
        }

        public void setProf(Professor primaryIns)
        {
            Contract.Assert(primaryIns != null, "undefined Professor");
            this.primaryInsrtuctor = primaryIns;            
        }
        public void setDept(Department dept)
        {
            Contract.Assert(dept != null, "undefined Department");
            this.taDepartment = dept;
        }
    }
}
