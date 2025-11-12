module.exports = (sequelize, DataTypes) => {
  const Venta = sequelize.define('Venta', {
    id: { type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true },
    personaId: { type: DataTypes.INTEGER },
    productoId: { type: DataTypes.INTEGER },
    ubicacionId: { type: DataTypes.INTEGER },
    cantidad: { type: DataTypes.INTEGER, defaultValue: 1 },
    total: { type: DataTypes.DECIMAL(12,2) },
    fecha: { type: DataTypes.DATE, defaultValue: DataTypes.NOW }
  }, { tableName: 'venta', timestamps: false });
  return Venta;
};
