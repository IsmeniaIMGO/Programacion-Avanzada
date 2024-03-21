db = connect( 'mongodb://root:example@localhost:27017/proyecto?authSource=admin' );
db.clientes.insertMany([
    {
        _id: 'Cliente1',
        cedula: '123456789',
        email: 'juan@email.com',
        nombre: 'Juan',
        _class: 'practica.modelo.documentos.Cliente'
    },
    {
        _id: 'Cliente2',
        cedula: '987654321',
        email: 'marce@email.com',
        nombre: 'Marcela',
        _class: 'practica.modelo.documentos.Cliente'
    },
    {
        _id: 'Cliente3',
        cedula: '123123123',
        email: 'sofi@email.com',
        nombre: 'Sofia',
        _class: 'practica.modelo.documentos.Cliente'
    }
]);