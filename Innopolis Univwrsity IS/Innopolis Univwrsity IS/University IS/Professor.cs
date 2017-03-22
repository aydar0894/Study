using System.Diagnostics.Contracts;

namespace Innopolis_Univwrsity_IS.University_IS
{
    class Professor : Person
    {

        private string degree;
        private Department profsDepartment;
        private TAs profsTAs;
        private Subjects profsSubjects;

        public string Degree
        {
            get
            {
                return degree;
            }

            set
            {
                degree = value;
            }
        }

        internal Department ProfsDepartment
        {
            get
            {
                return profsDepartment;
            }

            set
            {
                Contract.Assert(value != null, "Set the correct Department");
                profsDepartment = value;
            }
        }

        internal TAs ProfsTAs
        {
            get
            {
                return profsTAs;
            }

            set
            {
                Contract.Assert(value != null, "Set the correct TAs");
                profsTAs = value;
            }
        }

        internal Subjects ProfsSubjects
        {
            get
            {
                return profsSubjects;
            }

            set
            {
               // Contract.Assert(value != null, "Set the correct Subject");
                profsSubjects = value;
            }
        }

        public Professor()
        {

        }
        public Professor(string name, string degree,int count)
        {
            //Contract.Assert(name != null && degree != null, "Enter the correct parameters");
            this.Name = name;
            this.Degree = degree;
            this.Id = count;
            ProfsDepartment = new Department();
            ProfsSubjects = new Subjects();
            ProfsTAs = new TAs();
        }

        public Professor(string name, string degree, int count, Department dept, TA ta)
        {
            this.Name = name;
            this.Degree = degree;
            this.Id = count;
        }

        public Professor setDept(Department dept)
        {
            Contract.Assert(dept != null, "Set the correct Department");
            this.ProfsDepartment = dept;
            this.ProfsDepartment.DeptProfessors.add(this);
            return this;
        }

        public Professor addTA(TA ta)
        {
            Contract.Assert(ta != null, "Set the correct TA");
            this.ProfsTAs.Tas[this.ProfsTAs.getCount()] = ta;
            this.ProfsTAs.Tas[this.ProfsTAs.getCount()].primaryInsrtuctor = this;
            this.ProfsTAs.setCount(this.ProfsTAs.getCount()+1);
            return this;
        }
        public Professor addSubject(Subject subj)
        {
            Contract.Assert(subj != null, "Set the correct Subject");
            this.ProfsSubjects.subjects[this.ProfsSubjects.getCount()] = subj;
            this.ProfsSubjects.subjects[this.ProfsSubjects.getCount()].SubjectInstructor = this;
            this.ProfsSubjects.count++;
            return this;
        }
    }
}
