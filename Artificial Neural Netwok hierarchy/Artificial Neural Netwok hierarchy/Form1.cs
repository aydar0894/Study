using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Artificial_Neural_Netwok_hierarchy
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            
            treeView1.Nodes.Add("Artificial Neural Netwok hierarchy");
            Type[] typelist = System.Reflection.Assembly.GetExecutingAssembly().GetTypes().Where(t => t.Namespace == "Artificial_Neural_Netwok_hierarchy.ANN").ToArray();
            for(int i = 0; i <typelist.Length;i++)
            {
                treeView1.Nodes[0].Nodes.Add(typelist[i].Name);
            }
            
        }
    }
}
