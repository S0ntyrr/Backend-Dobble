module.exports = (sequelize, DataTypes) => {
  const Ubicacion = sequelize.define('Ubicacion', {
    id: { type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true },
    nombre: { type: DataTypes.STRING },
    latitud: { type: DataTypes.DOUBLE },
    longitud: { type: DataTypes.DOUBLE },
    direccion: { type: DataTypes.TEXT }
  }, { tableName: 'ubicacion', timestamps: false });
  return Ubicacion;
};
