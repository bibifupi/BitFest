export interface Comentarios {
    idComentario?: number; 
    texto: string;
    fecha: Date;
    idEvento: { idEvento: number };
    idUsuario: { idUsuario: number };
}
