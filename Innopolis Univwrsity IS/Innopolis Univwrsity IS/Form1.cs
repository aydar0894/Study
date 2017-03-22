using System;
using System.Windows.Forms;
using Excel = Microsoft.Office.Interop.Excel;
using System.Threading;

namespace Innopolis_Univwrsity_IS
{
    public partial class Form1 : Form
    {
        University_IS.University innopolisUniversity;
        University_IS.ActionsIU innopolisActions;
        public Form1()
        {

            innopolisUniversity = new University_IS.University();
            innopolisActions = new University_IS.ActionsIU();
            InitializeComponent();
        }


        private void addNewDepartmentToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }




        private void toolStripTextBox1_Click(object sender, EventArgs e)
        {
            toolStripTextBox1.Text = "";
        }

        private void toolStripTextBox2_Click(object sender, EventArgs e)
        {
            toolStripTextBox2.Text = "";
        }

        private void toolStripTextBox3_Click(object sender, EventArgs e)
        {
            toolStripTextBox3.Text = "";
        }

        private void toolStripTextBox4_Click(object sender, EventArgs e)
        {
            toolStripTextBox4.Text = "";
        }

        private void toolStripTextBox5_Click(object sender, EventArgs e)
        {
            toolStripTextBox5.Text = "";
        }

        private void toolStripTextBox6_Click(object sender, EventArgs e)
        {
            toolStripTextBox6.Text = "";
        }

        private void toolStripTextBox7_Click(object sender, EventArgs e)
        {
            toolStripTextBox7.Text = "";
        }

        private void toolStripTextBox8_Click(object sender, EventArgs e)
        {
            toolStripTextBox8.Text = "";
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            switch (groupBox1.Text)
            {
                case "Department Edit Pannel":
                    University_IS.Department dept;
                    try
                    {
                        if ((dept = innopolisUniversity.Departments.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            listBox6.Visible = true;
                            button5.Visible = true;
                            listBox6.Items.Clear();
                            listBox5.Items.Clear();
                            listBox4.Items.Clear();
                            listBox3.Items.Clear();
                            listBox2.Items.Clear();
                            listBox1.Items.Clear();
                            button5.Text = "Add Group";
                            button4.Text = "Add Professor";
                            button3.Text = "Add Subject";

                            //--/

                            try
                            {

                                for (int i = 0; i < innopolisUniversity.Departments.search(comboBox1.SelectedItem.ToString()).DeptGroups.Count; i++)
                                {
                                    listBox1.Items.Add(innopolisUniversity.Departments.search(comboBox1.SelectedItem.ToString()).DeptGroups.groups[i].Name);
                                }
                                for (int i = 0; i < innopolisUniversity.Departments.search(comboBox1.SelectedItem.ToString()).DeptProfessors.Count; i++)
                                {
                                    listBox2.Items.Add(innopolisUniversity.Departments.search(comboBox1.SelectedItem.ToString()).DeptProfessors.Professors1[i].Name);
                                }
                                for (int i = 0; i < innopolisUniversity.Departments.search(comboBox1.SelectedItem.ToString()).DeptSubjects.count; i++)
                                {
                                    listBox3.Items.Add(innopolisUniversity.Departments.search(comboBox1.SelectedItem.ToString()).DeptSubjects.subjects[i].Name);
                                }

                            }
                            catch (Exception ee)
                            {

                            }
                            //--/

                            for (int i = 0; i < innopolisUniversity.Groups.Count; i++)
                            {
                                listBox6.Items.Add(innopolisUniversity.Groups.groups[i].Name);
                            }
                            for (int i = 0; i < innopolisUniversity.Professors.Count; i++)
                            {
                                listBox5.Items.Add(innopolisUniversity.Professors.Professors1[i].Name);
                            }
                            for (int i = 0; i < innopolisUniversity.Subjects.count; i++)
                            {
                                listBox4.Items.Add(innopolisUniversity.Subjects.subjects[i].Name);
                            }
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Professor Edit Pannel":
                    University_IS.Professor prof;
                    try
                    {
                        if ((prof = innopolisUniversity.Professors.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            listBox6.Visible = true;
                            button5.Visible = true;
                            listBox6.Items.Clear();
                            listBox5.Items.Clear();
                            listBox4.Items.Clear();
                            listBox3.Items.Clear();
                            listBox2.Items.Clear();
                            listBox1.Items.Clear();
                            button5.Text = "Set Department";
                            button4.Text = "Add TA";
                            button3.Text = "Add Subject";

                            //--/
                            try
                            {
                                listBox1.Items.Add(innopolisUniversity.Professors.search(comboBox1.SelectedItem.ToString()).ProfsDepartment.Name);

                                for (int i = 0; i < innopolisUniversity.Professors.search(comboBox1.SelectedItem.ToString()).ProfsTAs.Count; i++)
                                {
                                    listBox2.Items.Add(innopolisUniversity.Professors.search(comboBox1.SelectedItem.ToString()).ProfsTAs.Tas[i].Name);
                                }
                                for (int i = 0; i < innopolisUniversity.Professors.search(comboBox1.SelectedItem.ToString()).ProfsSubjects.count; i++)
                                {
                                    listBox3.Items.Add(innopolisUniversity.Professors.search(comboBox1.SelectedItem.ToString()).ProfsSubjects.subjects[i].Name);
                                }

                            }
                            catch (Exception ee)
                            {

                            }

                            //--/

                            for (int i = 0; i < innopolisUniversity.Departments.Count; i++)
                            {
                                listBox6.Items.Add(innopolisUniversity.Departments.departments[i].Name);
                            }
                            for (int i = 0; i < innopolisUniversity.Tas.Count; i++)
                            {
                                listBox5.Items.Add(innopolisUniversity.Tas.Tas[i].Name);
                            }
                            for (int i = 0; i < innopolisUniversity.Subjects.count; i++)
                            {
                                listBox4.Items.Add(innopolisUniversity.Subjects.subjects[i].Name);
                            }
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Group Edit Pannel":
                    University_IS.Group group;
                    try
                    {
                        if ((group = innopolisUniversity.Groups.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            listBox6.Visible = true;
                            button5.Visible = true;
                            listBox6.Items.Clear();
                            listBox5.Items.Clear();
                            listBox4.Items.Clear();
                            listBox3.Items.Clear();
                            listBox2.Items.Clear();
                            listBox1.Items.Clear();
                            button5.Text = "Add Student";
                            button4.Text = "Set Department";
                            button3.Text = "Add Subject";

                            //--/

                            try
                            {


                                for (int i = 0; i < innopolisUniversity.Groups.search(comboBox1.SelectedItem.ToString()).GroupStudents.Count; i++)
                                {
                                    listBox1.Items.Add(innopolisUniversity.Groups.search(comboBox1.SelectedItem.ToString()).GroupStudents.Students1[i].Name);
                                }

                                listBox2.Items.Add(innopolisUniversity.Groups.search(comboBox1.SelectedItem.ToString()).GroupDepartment.Name);


                                for (int i = 0; i < innopolisUniversity.Groups.search(comboBox1.SelectedItem.ToString()).GroupSubjects.count; i++)
                                {
                                    listBox3.Items.Add(innopolisUniversity.Groups.search(comboBox1.SelectedItem.ToString()).GroupSubjects.subjects[i].Name);
                                }

                            }
                            catch (Exception ee)
                            {

                            }
                            //--/


                            for (int i = 0; i < innopolisUniversity.Students.Count; i++)
                            {
                                listBox6.Items.Add(innopolisUniversity.Students.Students1[i].Name);
                            }
                            for (int i = 0; i < innopolisUniversity.Departments.Count; i++)
                            {
                                listBox5.Items.Add(innopolisUniversity.Departments.departments[i].Name);
                            }
                            for (int i = 0; i < innopolisUniversity.Subjects.count; i++)
                            {
                                listBox4.Items.Add(innopolisUniversity.Subjects.subjects[i].Name);
                            }
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Lab Edit Pannel":
                    University_IS.Lab lab;
                    try
                    {
                        if ((lab = innopolisUniversity.Labs.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            listBox6.Visible = true;
                            button5.Visible = true;
                            listBox6.Items.Clear();
                            listBox5.Items.Clear();
                            listBox4.Items.Clear();
                            listBox3.Items.Clear();
                            listBox2.Items.Clear();
                            listBox1.Items.Clear();
                            button5.Text = "Set Professor";
                            button4.Text = "Set Department";
                            button3.Text = "Add Student";

                            //--/


                            try
                            {
                                listBox1.Items.Add(innopolisUniversity.Labs.search(comboBox1.SelectedItem.ToString()).LabProfessor.Name);


                                listBox2.Items.Add(innopolisUniversity.Labs.search(comboBox1.SelectedItem.ToString()).LabDepartment.Name);


                                for (int i = 0; i < innopolisUniversity.Labs.search(comboBox1.SelectedItem.ToString()).LabStudents.Count; i++)
                                {
                                    listBox3.Items.Add(innopolisUniversity.Labs.search(comboBox1.SelectedItem.ToString()).LabStudents.Students1[i].Name);
                                }
                            }
                            catch (Exception ee)
                            {

                            }

                            //--/


                            for (int i = 0; i < innopolisUniversity.Professors.Count; i++)
                            {
                                listBox6.Items.Add(innopolisUniversity.Professors.Professors1[i].Name);
                            }
                            for (int i = 0; i < innopolisUniversity.Departments.Count; i++)
                            {
                                listBox5.Items.Add(innopolisUniversity.Departments.departments[i].Name);
                            }
                            for (int i = 0; i < innopolisUniversity.Students.Count; i++)
                            {
                                listBox4.Items.Add(innopolisUniversity.Students.Students1[i].Name);
                            }
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Student Edit Pannel":
                    University_IS.Student student;
                    try
                    {
                        if ((student = innopolisUniversity.Students.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            listBox6.Visible = false;
                            button5.Visible = false;
                            listBox6.Items.Clear();
                            listBox5.Items.Clear();
                            listBox4.Items.Clear();
                            listBox3.Items.Clear();
                            listBox2.Items.Clear();
                            listBox1.Items.Clear();
                            button4.Text = "Set Group";
                            button3.Text = "Set Department";


                            //--/


                            try
                            {
                                listBox1.Items.Add(innopolisUniversity.Students.search(comboBox1.SelectedItem.ToString()).StudentGroup.Name);


                                listBox2.Items.Add(innopolisUniversity.Students.search(comboBox1.SelectedItem.ToString()).StudentDepartment.Name);
                            }
                            catch (Exception ee)
                            {

                            }

                            //--/


                            for (int i = 0; i < innopolisUniversity.Groups.Count; i++)
                            {
                                listBox5.Items.Add(innopolisUniversity.Groups.groups[i].Name);
                            }
                            for (int i = 0; i < innopolisUniversity.Departments.Count; i++)
                            {
                                listBox4.Items.Add(innopolisUniversity.Departments.departments[i].Name);
                            }
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Subject Edit Pannel":
                    University_IS.Subject subject;
                    try
                    {
                        if ((subject = innopolisUniversity.Subjects.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            listBox6.Visible = false;
                            button5.Visible = false;
                            listBox6.Items.Clear();
                            listBox5.Items.Clear();
                            listBox4.Items.Clear();
                            listBox3.Items.Clear();
                            listBox2.Items.Clear();
                            listBox1.Items.Clear();
                            button4.Text = "Set Professor";
                            button3.Text = "Set Department";



                            //--/


                            try
                            {
                                listBox1.Items.Add(innopolisUniversity.Subjects.search(comboBox1.SelectedItem.ToString()).SubjectInstructor.Name);


                                listBox2.Items.Add(innopolisUniversity.Subjects.search(comboBox1.SelectedItem.ToString()).SubjectDepartment.Name);
                            }
                            catch (Exception ee)
                            {

                            }

                            //--/

                            for (int i = 0; i < innopolisUniversity.Professors.Count; i++)
                            {
                                listBox5.Items.Add(innopolisUniversity.Professors.Professors1[i].Name);
                            }
                            for (int i = 0; i < innopolisUniversity.Departments.Count; i++)
                            {
                                listBox4.Items.Add(innopolisUniversity.Departments.departments[i].Name);
                            }
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "TA Edit Pannel":
                    University_IS.TA ta;
                    try
                    {
                        if ((ta = innopolisUniversity.Tas.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            listBox6.Visible = false;
                            button5.Visible = false;
                            listBox6.Items.Clear();
                            listBox5.Items.Clear();
                            listBox4.Items.Clear();
                            listBox3.Items.Clear();
                            listBox2.Items.Clear();
                            listBox1.Items.Clear();
                            button4.Text = "Set Professor";
                            button3.Text = "Set Department";


                            //--/


                            try
                            {
                                listBox1.Items.Add(innopolisUniversity.Tas.search(comboBox1.SelectedItem.ToString()).primaryInsrtuctor.Name);


                                listBox2.Items.Add(innopolisUniversity.Tas.search(comboBox1.SelectedItem.ToString()).taDepartment.Name);
                            }
                            catch (Exception ee)
                            {

                            }

                            //--/

                            for (int i = 0; i < innopolisUniversity.Professors.Count; i++)
                            {
                                listBox5.Items.Add(innopolisUniversity.Professors.Professors1[i].Name);
                            }
                            for (int i = 0; i < innopolisUniversity.Departments.Count; i++)
                            {
                                listBox4.Items.Add(innopolisUniversity.Departments.departments[i].Name);
                            }
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
            }


        }



        private void Form1_Load(object sender, EventArgs e)
        {
            groupBox1.Visible = false;
            groupBox2.Visible = false;
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void departmentsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            groupBox2.Visible = false;
            groupBox1.Text = "Department Edit Pannel";
            comboBox1.Text = "Select Department";
            comboBox1.Items.Clear();
            groupBox1.Visible = true;
            for (int i = 0; i < innopolisUniversity.Departments.Count; i++)
                comboBox1.Items.Add(innopolisUniversity.Departments.departments[i].Name);


        }

        private void professorsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            groupBox2.Visible = false;
            groupBox1.Text = "Professor Edit Pannel";
            comboBox1.Text = "Select Professor";
            comboBox1.Items.Clear();
            groupBox1.Visible = true;
            for (int i = 0; i < innopolisUniversity.Professors.Count; i++)
                comboBox1.Items.Add(innopolisUniversity.Professors.Professors1[i].Name);
        }

        private void groupsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            groupBox2.Visible = false;
            groupBox1.Text = "Group Edit Pannel";
            comboBox1.Text = "Select Group";
            comboBox1.Items.Clear();
            groupBox1.Visible = true;
            for (int i = 0; i < innopolisUniversity.Groups.Count; i++)
                comboBox1.Items.Add(innopolisUniversity.Groups.groups[i].Name);
        }

        private void labsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            groupBox2.Visible = false;
            groupBox1.Text = "Lab Edit Pannel";
            comboBox1.Text = "Select Lab";
            comboBox1.Items.Clear();
            groupBox1.Visible = true;
            for (int i = 0; i < innopolisUniversity.Labs.Count; i++)
                comboBox1.Items.Add(innopolisUniversity.Labs.Labs1[i].Name);
        }

        private void studentsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            groupBox2.Visible = false;
            groupBox1.Text = "Student Edit Pannel";
            comboBox1.Text = "Select Student";
            comboBox1.Items.Clear();
            groupBox1.Visible = true;
            for (int i = 0; i < innopolisUniversity.Students.Count; i++)
                comboBox1.Items.Add(innopolisUniversity.Students.Students1[i].Name);
        }

        private void subjectsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            groupBox2.Visible = false;
            groupBox1.Text = "Subject Edit Pannel";
            comboBox1.Text = "Select Subject";
            comboBox1.Items.Clear();
            groupBox1.Visible = true;
            for (int i = 0; i < innopolisUniversity.Subjects.count; i++)
                comboBox1.Items.Add(innopolisUniversity.Subjects.subjects[i].Name);
        }

        private void tAsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            groupBox2.Visible = false;
            groupBox1.Text = "TA Edit Pannel";
            comboBox1.Text = "Select TA";
            comboBox1.Items.Clear();
            groupBox1.Visible = true;
            for (int i = 0; i < innopolisUniversity.Tas.Count; i++)
                comboBox1.Items.Add(innopolisUniversity.Tas.Tas[i].Name);
        }

        private void addToolStripMenuItem_Click(object sender, EventArgs e)
        {


            University_IS.Department dept = new University_IS.Department(toolStripTextBox1.Text, innopolisUniversity.Departments.Count);
            innopolisActions.addDepartment(innopolisUniversity.Departments, dept);
            dept = null;
        }


        private void addToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            University_IS.Professor prof = new University_IS.Professor(toolStripTextBox2.Text, toolStripTextBox3.Text, innopolisUniversity.Professors.Count);
            innopolisActions.addProfessor(innopolisUniversity.Professors, prof);
            prof = null;
        }

        private void addToolStripMenuItem2_Click(object sender, EventArgs e)
        {
            University_IS.Group group = new University_IS.Group(toolStripTextBox4.Text, innopolisUniversity.Groups.Count);
            innopolisActions.addGroup(innopolisUniversity.Groups, group);
            group = null;
        }

        private void addToolStripMenuItem3_Click(object sender, EventArgs e)
        {
            University_IS.Lab lab = new University_IS.Lab(toolStripTextBox5.Text, innopolisUniversity.Labs.Count);
            innopolisActions.addLab(innopolisUniversity.Labs, lab);
            lab = null;
        }

        private void addToolStripMenuItem4_Click(object sender, EventArgs e)
        {
            University_IS.Student student = new University_IS.Student(toolStripTextBox6.Text, innopolisUniversity.Students.Count);
            innopolisActions.addStudent(innopolisUniversity.Students, student);
            student = null;
        }

        private void addToolStripMenuItem5_Click(object sender, EventArgs e)
        {
            University_IS.Subject subject = new University_IS.Subject(toolStripTextBox7.Text, innopolisUniversity.Subjects.count);
            innopolisActions.addSubject(innopolisUniversity.Subjects, subject);
            subject = null;
        }

        private void addToolStripMenuItem6_Click(object sender, EventArgs e)
        {
            University_IS.TA ta = new University_IS.TA(toolStripTextBox8.Text, innopolisUniversity.Tas.Count);
            innopolisActions.addTA(innopolisUniversity.Tas, ta);
            ta = null;
        }

        private void button5_Click(object sender, EventArgs e)
        {
            switch (groupBox1.Text)
            {
                case "Department Edit Pannel":
                    University_IS.Department dept;
                    try
                    {
                        if ((dept = innopolisUniversity.Departments.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            innopolisActions.addDeptGroup(dept, innopolisUniversity.Groups.search(listBox6.SelectedItem.ToString()));
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Professor Edit Pannel":
                    University_IS.Professor prof;
                    try
                    {
                        if ((prof = innopolisUniversity.Professors.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            innopolisActions.setProfDepartment(prof, innopolisUniversity.Departments.search(listBox6.SelectedItem.ToString()));
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Group Edit Pannel":
                    University_IS.Group group;
                    try
                    {
                        if ((group = innopolisUniversity.Groups.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            innopolisActions.addGroupStudent(group, innopolisUniversity.Students.search(listBox6.SelectedItem.ToString()));
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Lab Edit Pannel":
                    University_IS.Lab lab;
                    try
                    {
                        if ((lab = innopolisUniversity.Labs.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            innopolisActions.setLabProfessor(lab, innopolisUniversity.Professors.search(listBox6.SelectedItem.ToString()));
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Student Edit Pannel":
                    University_IS.Student student;
                    try
                    {
                        if ((student = innopolisUniversity.Students.search(comboBox1.SelectedItem.ToString())) != null)
                        {

                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Subject Edit Pannel":
                    University_IS.Subject subject;
                    try
                    {
                        if ((subject = innopolisUniversity.Subjects.search(comboBox1.SelectedItem.ToString())) != null)
                        {

                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "TA Edit Pannel":
                    University_IS.TA ta;
                    try
                    {
                        if ((ta = innopolisUniversity.Tas.search(comboBox1.SelectedItem.ToString())) != null)
                        {

                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            switch (groupBox1.Text)
            {
                case "Department Edit Pannel":
                    University_IS.Department dept;
                    try
                    {
                        if ((dept = innopolisUniversity.Departments.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            innopolisActions.addDeptProfessor(dept, innopolisUniversity.Professors.search(listBox5.SelectedItem.ToString()));
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Professor Edit Pannel":
                    University_IS.Professor prof;
                    try
                    {
                        if ((prof = innopolisUniversity.Professors.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            innopolisActions.addProfTA(prof, innopolisUniversity.Tas.search(listBox5.SelectedItem.ToString()));
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Group Edit Pannel":
                    University_IS.Group group;
                    try
                    {
                        if ((group = innopolisUniversity.Groups.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            innopolisActions.setGroupDepartment(group, innopolisUniversity.Departments.search(listBox5.SelectedItem.ToString()));
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Lab Edit Pannel":
                    University_IS.Lab lab;
                    try
                    {
                        if ((lab = innopolisUniversity.Labs.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            innopolisActions.setLabDepartment(lab, innopolisUniversity.Departments.search(listBox5.SelectedItem.ToString()));
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Student Edit Pannel":
                    University_IS.Student student;
                    try
                    {
                        if ((student = innopolisUniversity.Students.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            innopolisActions.setStudGroup(student, innopolisUniversity.Groups.search(listBox5.SelectedItem.ToString()));
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Subject Edit Pannel":
                    University_IS.Subject subject;
                    try
                    {
                        if ((subject = innopolisUniversity.Subjects.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            innopolisActions.setSubjProfessor(subject, innopolisUniversity.Professors.search(listBox5.SelectedItem.ToString()));
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "TA Edit Pannel":
                    University_IS.TA ta;
                    try
                    {
                        if ((ta = innopolisUniversity.Tas.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            innopolisActions.setTAjProfessor(ta, innopolisUniversity.Professors.search(listBox5.SelectedItem.ToString()));
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
            }
        }
        private void button3_Click(object sender, EventArgs e)
        {
            switch (groupBox1.Text)
            {
                case "Department Edit Pannel":
                    University_IS.Department dept;
                    try
                    {
                        if ((dept = innopolisUniversity.Departments.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            innopolisActions.addDeptSubj(dept, innopolisUniversity.Subjects.search(listBox4.SelectedItem.ToString()));
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Professor Edit Pannel":
                    University_IS.Professor prof;
                    try
                    {
                        if ((prof = innopolisUniversity.Professors.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            innopolisActions.addProfSubj(prof, innopolisUniversity.Subjects.search(listBox4.SelectedItem.ToString()));
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Group Edit Pannel":
                    University_IS.Group group;
                    try
                    {
                        if ((group = innopolisUniversity.Groups.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            innopolisActions.addGroupSubject(group, innopolisUniversity.Subjects.search(listBox4.SelectedItem.ToString()));
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Lab Edit Pannel":
                    University_IS.Lab lab;
                    try
                    {
                        if ((lab = innopolisUniversity.Labs.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            innopolisActions.addLabStudent(lab, innopolisUniversity.Students.search(listBox4.SelectedItem.ToString()));
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Student Edit Pannel":
                    University_IS.Student student;
                    try
                    {
                        if ((student = innopolisUniversity.Students.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            innopolisActions.setStudDepartment(student, innopolisUniversity.Departments.search(listBox4.SelectedItem.ToString()));
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "Subject Edit Pannel":
                    University_IS.Subject subject;
                    try
                    {
                        if ((subject = innopolisUniversity.Subjects.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            innopolisActions.setSubjDepartment(subject, innopolisUniversity.Departments.search(listBox4.SelectedItem.ToString()));
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
                case "TA Edit Pannel":
                    University_IS.TA ta;
                    try
                    {
                        if ((ta = innopolisUniversity.Tas.search(comboBox1.SelectedItem.ToString())) != null)
                        {
                            innopolisActions.setTAjProfessor(ta, innopolisUniversity.Professors.search(listBox4.SelectedItem.ToString()));
                        }
                    }
                    catch (Exception ec)
                    {

                    }
                    break;
            }
        }

        private void importTimeTableToolStripMenuItem_Click(object sender, EventArgs e)
        {
            groupBox1.Visible = false;
            groupBox2.Visible = true;

        }

        private void menuStrip1_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void button6_Click(object sender, EventArgs e)
        {
            uploadTimeTable(false, null);
        }

        private void dataGridView1_DragDrop(object sender, DragEventArgs e)
        {
            uploadTimeTable(true, e);
        }


        private void dataGridView1_DragEnter(object sender, DragEventArgs e)
        {
            if (e.Data.GetDataPresent(DataFormats.FileDrop)) e.Effect = DragDropEffects.Move;
            else e.Effect = DragDropEffects.None;
        }

        private void uploadTimeTable(bool dragDrop, DragEventArgs e)
        {
            dataGridView1.Columns.Clear();
            dataGridView1.Rows.Clear();
            Excel.Workbook workBook = null;
            University_IS.TimeTable timeTable = new University_IS.TimeTable();
            if (dragDrop)
            {
                string[] path = (String[])e.Data.GetData(DataFormats.FileDrop);
                workBook = timeTable.upLoad(this, path[0]);
            }


            else workBook = timeTable.upLoad(this);
            Excel.Worksheet workSheet = (Excel.Worksheet)workBook.Sheets[1];
            string s;
            Thread.Sleep(4000);
            for (int i = 0; ; i++)
            {
                if ((s = Convert.ToString(workSheet.Cells[1, i + 1].value)) == null) break;
                if (i == 0) dataGridView1.Columns.Add(i.ToString(), "");
                else dataGridView1.Columns.Add(workSheet.Cells[1, i + 1].value, workSheet.Cells[1, i + 1].value);

            }
            var lastCell = workSheet.Cells.SpecialCells(Microsoft.Office.Interop.Excel.XlCellType.xlCellTypeLastCell);
            for (int i = 0;i< (int)lastCell.Row; i++)
            {
                dataGridView1.Rows.Add(1);
                for (int j = 0;j< (int)lastCell.Column; j++)
                {
                                      
                      dataGridView1.Rows[i].Cells[j].Value = Convert.ToString(workSheet.Cells[i + 1, j + 1].value);
                    

                }

            }       
            workBook.Close();
        }

        private void button7_Click(object sender, EventArgs e)
        {
            switch (groupBox1.Text)
            {
                case "Professor Edit Pannel":
                    dataGridView2.Columns.Clear();
                    dataGridView2.Rows.Clear();
                    string s = "";
                    int iterator = 0;
                    int temp = 0;
                    for (int i = 0;i<dataGridView1.ColumnCount ; i++)
                    {                     
                        dataGridView2.Columns.Add(i.ToString(), (Convert.ToString(dataGridView1.Rows[0].Cells[i].Value)));
                    }
                    dataGridView2.Rows.Add(1);
                    for (int i = 0;i< dataGridView1.RowCount; i++)
                    {
                        s = "";
                        for (int j = 0; j < dataGridView1.ColumnCount; j++)
                        {
                            s += Convert.ToString(dataGridView1.Rows[i].Cells[j].Value);
                        }
                        if (i == 0 || s.Contains(comboBox1.SelectedItem.ToString()))
                        {
                            dataGridView2.Rows.Add(1);
                            for (int j = 0; j < dataGridView1.ColumnCount; j++)
                            {
                               dataGridView2.Rows[iterator].Cells[j].Value = Convert.ToString(dataGridView1.Rows[i].Cells[j].Value);
                            }

                            iterator++;

                        }
                                           
                     
                    }              
                    break;
                case "Subject Edit Pannel":

                    dataGridView2.Columns.Clear();
                    dataGridView2.Rows.Clear();
                    s = "";
                   iterator = 0;

                    for (int i = 0; i < dataGridView1.ColumnCount; i++)
                    {
                        dataGridView2.Columns.Add(i.ToString(), (Convert.ToString(dataGridView1.Rows[0].Cells[i].Value)));
                    }
                    dataGridView2.Rows.Add(1);
                    for (int i = 0; i < dataGridView1.RowCount; i++)
                    {
                        s = "";
                        for (int j = 0; j < dataGridView1.ColumnCount; j++)
                        {
                            s += Convert.ToString(dataGridView1.Rows[i].Cells[j].Value);
                        }
                        if (i == 0 || s.Contains(comboBox1.SelectedItem.ToString()))
                        {
                            dataGridView2.Rows.Add(1);
                            for (int j = 0; j < dataGridView1.ColumnCount; j++)
                            {
                                dataGridView2.Rows[iterator].Cells[j].Value = Convert.ToString(dataGridView1.Rows[i].Cells[j].Value);
                            }

                            iterator++;

                        }


                    }
                    break;
                case "TA Edit Pannel":
                    dataGridView2.Columns.Clear();
                    dataGridView2.Rows.Clear();
                    s = "";
                    iterator = 0;

                    for (int i = 0; i < dataGridView1.ColumnCount; i++)
                    {
                        dataGridView2.Columns.Add(i.ToString(), (Convert.ToString(dataGridView1.Rows[0].Cells[i].Value)));
                    }
                    dataGridView2.Rows.Add(1);
                    for (int i = 0; i < dataGridView1.RowCount; i++)
                    {
                        s = "";
                        for (int j = 0; j < dataGridView1.ColumnCount; j++)
                        {
                            s += Convert.ToString(dataGridView1.Rows[i].Cells[j].Value);
                        }
                        if (i == 0 || s.Contains(comboBox1.SelectedItem.ToString()))
                        {
                            dataGridView2.Rows.Add(1);
                            for (int j = 0; j < dataGridView1.ColumnCount; j++)
                            {
                                dataGridView2.Rows[iterator].Cells[j].Value = Convert.ToString(dataGridView1.Rows[i].Cells[j].Value);
                            }

                            iterator++;

                        }


                    }
                    break;
                case "Student Edit Pannel":
                    dataGridView2.Columns.Clear();
                    dataGridView2.Rows.Clear();
                    s = "";
                   
                    iterator = 0;

                    for (int i = 0; i < dataGridView1.ColumnCount; i++)
                    {
                        dataGridView2.Columns.Add(i.ToString(), (Convert.ToString(dataGridView1.Rows[0].Cells[i].Value)));
                    }
                   // dataGridView2.Rows.Add(1);
                    for (int i = 0; i < dataGridView1.RowCount; i++)
                    {
                        temp = 0;
                     
                        for (int j = 0; j < dataGridView1.ColumnCount; j++)
                        {
                            if (j == 0 || dataGridView1.Columns[j].Name == innopolisUniversity.Students.search(comboBox1.SelectedItem.ToString()).StudentGroup.Name)
                            {
                                dataGridView2.Rows.Add(1);
                                dataGridView2.Rows[iterator].Cells[j].Value = Convert.ToString(dataGridView1.Rows[i].Cells[j].Value);
                                temp++;
                                
                                //break;
                            }

                        }
                        if (temp > 0) iterator++;
                        

                    }
                    break;
                case "Group Edit Pannel":
                    dataGridView2.Columns.Clear();
                    dataGridView2.Rows.Clear();
                    s = "";
                    iterator = 0;
                  
                    for (int i = 0; i < dataGridView1.ColumnCount; i++)
                    {
                        dataGridView2.Columns.Add(i.ToString(), (Convert.ToString(dataGridView1.Rows[0].Cells[i].Value)));
                    }
                   // dataGridView2.Rows.Add(1);
                    for (int i = 0; i < dataGridView1.RowCount; i++)
                    {
                        temp = 0;
                
                            for (int j = 0; j < dataGridView1.ColumnCount; j++)
                            {
                            if(j==0 || dataGridView1.Columns[j].Name == comboBox1.SelectedItem.ToString())
                            {
                                dataGridView2.Rows.Add(1);
                                dataGridView2.Rows[iterator].Cells[j].Value = Convert.ToString(dataGridView1.Rows[i].Cells[j].Value);
                                temp++;
                              
                                // break;
                            }
                                
                            }
                        if (temp > 0) iterator++;
                       
                    }
                    break;
            }
        }
    }
}
