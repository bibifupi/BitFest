
export interface Organizador {
    id: number;
    nombre: string;
  }
  
  export interface Eventos {
    idOrganizador: number;
    idEvento: number;
    categoria: string;
    descripcionCorta: string;
    fechaRealizacion: Date;
    descripcionLarga: string;
    fechaActualizacion: Date;
    imagen: string;
    titulo: string;
    organizador: Organizador;  
  }
  