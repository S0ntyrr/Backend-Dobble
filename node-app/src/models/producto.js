module.exports = (sequelize, DataTypes) => {
  const Producto = sequelize.define('Producto', {
    id: { type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true },
    nombre: { type: DataTypes.STRING },
    descripcion: { type: DataTypes.TEXT },
    precio: { type: DataTypes.DECIMAL(12,2) }
  }, { tableName: 'producto', timestamps: false });
  return Producto;
};
