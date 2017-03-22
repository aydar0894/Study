using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Excel = Microsoft.Office.Interop.Excel;


namespace Innopolis_Univwrsity_IS.University_IS
{
     class TimeTable
    {
        private Excel.Application excelapp;
        private Excel.Window excelWindow;

        private Excel.Workbook WorkBook;
        private Excel.Worksheet WorkSheet;
        private OpenFileDialog dialog;
        private string FileName;
        public Excel.Workbook upLoad(Form1 form)
        {
            dialog = new OpenFileDialog();
            dialog.Multiselect = false;
            dialog.DefaultExt = "*.xls;*.xlsx";
            dialog.Filter = "Microsoft Excel (*.xls*)|*.xls*";
            dialog.Title = "Выберите документ Excel";
            if (dialog.ShowDialog() != DialogResult.OK)
            {
                MessageBox.Show("Вы не выбрали файл для открытия", "Внимание", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return null;
            }
            FileName = dialog.FileName;
            excelapp = new Excel.Application();
            excelapp.Visible = false;
           
            
            WorkBook = excelapp.Workbooks.Open(FileName);
            WorkSheet = (Excel.Worksheet)WorkBook.Sheets[1];
            //excelapp.Quit();
            return WorkBook;                      
        }

        public Excel.Workbook upLoad(Form1 form, String path)
        {
            
            FileName = path;
            excelapp = new Excel.Application();
            excelapp.Visible = false;


            WorkBook = excelapp.Workbooks.Open(FileName);

            WorkSheet = (Excel.Worksheet)WorkBook.Sheets[1];
            //  excelapp.Quit();
            return WorkBook;


        }

    }
}
