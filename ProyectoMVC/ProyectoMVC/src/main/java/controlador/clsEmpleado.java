/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoEmpleados;
/**
 *
 * @author visitante
 */
public class clsEmpleado {
    private int CodigoEmpleado;
    private String NombreEmpleado;
    private String CodigoPuesto;
    private String codigoDepartamento;
    private int SueldoEmpleado;
    private String EstatusEmpleado;

    public int getCodigoEmpleado() {
        return CodigoEmpleado;
    }

    public void setCodigoEmpleado(int CodigoEmpleado) {
        this.CodigoEmpleado = CodigoEmpleado;
    }

    public String getNombreEmpleado() {
        return NombreEmpleado;
    }

    public void setNombreEmpleado(String NombreEmpleado) {
        this.NombreEmpleado = NombreEmpleado;
    }

    public String getCodigoPuesto() {
        return CodigoPuesto;
    }

    public void setCodigoPuesto(String CodigoPuesto) {
        this.CodigoPuesto = CodigoPuesto;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public int getSueldoEmpleado() {
        return SueldoEmpleado;
    }

    public void setSueldoEmpleado(int SueldoEmpleado) {
        this.SueldoEmpleado = SueldoEmpleado;
    }

    public String getEstatusEmpleado() {
        return EstatusEmpleado;
    }

    public void setEstatusEmpleado(String EstatusEmpleado) {
        this.EstatusEmpleado = EstatusEmpleado;
    }

    public clsEmpleado(String EstatusEmpleado) {
        this.EstatusEmpleado = EstatusEmpleado;
    }

    public clsEmpleado(String codigoDepartamento, int SueldoEmpleado, String EstatusEmpleado) {
        this.codigoDepartamento = codigoDepartamento;
        this.SueldoEmpleado = SueldoEmpleado;
        this.EstatusEmpleado = EstatusEmpleado;
    }

    public clsEmpleado(int CodigoEmpleado, String NombreEmpleado, String CodigoPuesto, String codigoDepartamento, int SueldoEmpleado, String EstatusEmpleado) {
        this.CodigoEmpleado = CodigoEmpleado;
        this.NombreEmpleado = NombreEmpleado;
        this.CodigoPuesto = CodigoPuesto;
        this.codigoDepartamento = codigoDepartamento;
        this.SueldoEmpleado = SueldoEmpleado;
        this.EstatusEmpleado = EstatusEmpleado;
    }

    public clsEmpleado(int CodigoEmpleado, String NombreEmpleado, String CodigoPuesto) {
        this.CodigoEmpleado = CodigoEmpleado;
        this.NombreEmpleado = NombreEmpleado;
        this.CodigoPuesto = CodigoPuesto;
    }

    public clsEmpleado(int CodigoEmpleado, String NombreEmpleado) {
        this.CodigoEmpleado = CodigoEmpleado;
        this.NombreEmpleado = NombreEmpleado;
    }

    public clsEmpleado(int CodigoEmpleado) {
        this.CodigoEmpleado = CodigoEmpleado;
    }

    public clsEmpleado() {
    }
    //Metodos de acceso a la capa controlador
    public clsEmpleado getBuscarInformacionEmpleadosPorNombre(clsEmpleado empleado)
    {
        daoEmpleados daoempleado = new daoEmpleados();
        return daoempleado.consultaEmpleadoPorNombre(empleado);
    }
    public clsEmpleado getBuscarInformacionEmpleadosPorId(clsEmpleado empleado)
    {
        daoEmpleados daoempleado = new daoEmpleados();
        return daoempleado.consultaEmpleadosPorId(empleado);
    }    
    public List<clsEmpleado> getListadoEmpleados()
    {
        daoEmpleados daoempleados = new daoEmpleados();
        List<clsEmpleado> listadoEmpleados = daoempleados.consultaEmpleados();
        return listadoEmpleados;
    }
    public int setBorrarEmpleados(clsEmpleado empleados)
    {
        daoEmpleados daoempleados = new daoEmpleados();
        return daoempleados.borrarEmpleados(empleados);
    }          
    public int setIngresarEmpleados(clsEmpleado empleados)
    {
        daoEmpleados daoempleados = new daoEmpleados();
        return daoempleados.ingresaEmpleados(empleados);
    }              
    public int setModificarEmpleados(clsEmpleado empleados)
    {
        daoEmpleados daoempleados = new daoEmpleados();
        return daoempleados.actualizaEmpleados(empleados);
    }              
}

