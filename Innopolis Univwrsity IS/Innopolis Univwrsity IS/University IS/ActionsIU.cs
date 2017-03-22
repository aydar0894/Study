using System;
using System.Diagnostics.Contracts;


namespace Innopolis_Univwrsity_IS.University_IS
{
    class ActionsIU
    {
        public ActionsIU()
        {

        }
        
        //-Professors
        public void addProfessor(Professors profs, Professor prof)
        {
            Contract.Assert(prof != null && profs != null, "Enter the correct parameters");
            profs.add(prof);
        }

        public void addProfTA(Professor prof, TA ta)
        {
            Contract.Assert(prof != null && ta != null, "Enter the correct parameters");
            prof.ProfsTAs.add(ta);
            ta.primaryInsrtuctor = prof;
        }

        public void addProfSubj(Professor prof, Subject subj)
        {
            Contract.Assert(prof != null && subj != null, "Enter the correct parameters");
            prof.ProfsSubjects.add(subj);
            subj.SubjectInstructor = prof;
        }

        public void setProfDepartment(Professor prof, Department dept)
        {
            Contract.Assert(prof != null && dept != null, "Enter the correct parameters");
            prof.ProfsDepartment = dept;
            dept.DeptProfessors.add(prof);
        }

        //--/Professors

        //-- Departments

        public void addDepartment(Departments depts, Department dept)
        {
            Contract.Assert(dept != null && depts != null, "Enter the correct parameters");
            depts.add(dept);
        }

        public void addDeptGroup(Department dept, Group gr)
        {
            Contract.Assert(dept != null && gr != null, "Enter the correct parameters");
            dept.DeptGroups.add(gr);
            gr.GroupDepartment = dept;
        }

        public void addDeptProfessor(Department dept, Professor prof)
        {
            Contract.Assert(dept != null && prof != null, "Enter the correct parameters");
            dept.DeptProfessors.add(prof);
            prof.ProfsDepartment = dept;
        }
        public void addDeptSubj(Department dept, Subject subj)
        {
            Contract.Assert(dept != null && subj != null, "Enter the correct parameters");
            dept.DeptSubjects.add(subj); 
                       
        }
        //-- /Departments

        //-- Groups

        public void addGroup(Groups groups, Group group)
        {
            groups.add(group);
        }
        public void addGroupStudent(Group group, Student stud)
        {
            group.GroupStudents.add(stud);
            stud.StudentGroup = group;
        }        
         public void addGroupSubject(Group group, Subject subj)
        {
            group.GroupSubjects.add(subj);            
        }
        public void setGroupDepartment(Group group, Department dept)
        {
            group.GroupDepartment = dept;
            dept.DeptGroups.add(group);
        }

        //-- /Groups


        //-- Labs
        public void addLab(Labs labs, Lab lab)
        {
            labs.add(lab);
        }

        public void addLabStudent(Lab lab, Student student)
        {
            lab.LabStudents.add(student);
        }
        public void setLabDepartment(Lab lab, Department dept)
        {
            lab.LabDepartment = dept;
            
        }
        public void setLabProfessor(Lab lab, Professor professor)
        {
            lab.LabProfessor = professor;
        }


        //-- /Labs

        //-- Students

        public void addStudent(Students students, Student student)
        {
            students.add(student);
        }
        public void setStudGroup(Student student, Group group)
        {
            student.StudentGroup = group;
            group.GroupStudents.add(student);
        }
        public void setStudDepartment(Student student, Department department)
        {
            student.StudentDepartment = department;
        }


        //-- /Students

        //-- Subjects

        public void addSubject(Subjects subjects, Subject subject)
        {
            subjects.add(subject);
        }
        public void setSubjProfessor(Subject subject,Professor prof)
        {
            subject.SubjectInstructor = prof;
            prof.ProfsSubjects.add(subject);
        }

        public void setSubjDepartment(Subject subject, Department dept)
        {
            subject.SubjectDepartment = dept;
            dept.DeptSubjects.add(subject);
        }

        //-- /Subjects

        //-- TAs

        public void addTA(TAs tas, TA ta)
        {
            tas.add(ta);
        }

        public void setTAjProfessor(TA ta, Professor prof)
        {
            ta.primaryInsrtuctor = prof;
            prof.ProfsTAs.add(ta);
        }

        public void setTADepartment(TA ta, Department dept)
        {
            ta.taDepartment = dept;            
        }

        //-- /TAs
    }
}
