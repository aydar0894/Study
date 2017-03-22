using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Innopolis_Univwrsity_IS.University_IS
{
    class University
    {
        private Departments departments;
        private Professors professors;
        private Groups groups;
        private Labs labs;
        private Students students;
        private Subjects subjects;
        private TAs tas;
        private TimeTable timeTable;

        internal Departments Departments
        {
            get
            {
                return departments;
            }

            set
            {
                departments = value;
            }
        }

        internal Professors Professors
        {
            get
            {
                return professors;
            }

            set
            {
                professors = value;
            }
        }

        internal Groups Groups
        {
            get
            {
                return groups;
            }

            set
            {
                groups = value;
            }
        }

        internal Labs Labs
        {
            get
            {
                return labs;
            }

            set
            {
                labs = value;
            }
        }

        internal Students Students
        {
            get
            {
                return students;
            }

            set
            {
                students = value;
            }
        }

        internal Subjects Subjects
        {
            get
            {
                return subjects;
            }

            set
            {
                subjects = value;
            }
        }

        internal TAs Tas
        {
            get
            {
                return tas;
            }

            set
            {
                tas = value;
            }
        }

        internal TimeTable TimeTable
        {
            get
            {
                return timeTable;
            }

            set
            {
                timeTable = value;
            }
        }

        public University()
        {
            Departments = new Departments();
            Professors = new Professors();
            Groups = new Groups();
            Labs = new Labs();
            Students = new Students();
            Subjects = new Subjects();
            Tas = new TAs();
            TimeTable = new TimeTable();
        }

    }
}
