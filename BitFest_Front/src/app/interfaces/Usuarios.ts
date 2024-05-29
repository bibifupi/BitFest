import { rol } from "./Rol.enum";

export interface Usuarios{
idUsuario:number,
nombreUsuario:string,
contraseña:string,
apellidos:string,
fechaRegistro:Date,
email: string,
imagenPerfil:string,
nombre:string,
rol: rol;
}