<template>
  <el-dialog type="warning" title="Διαχείριση Προμηθευτή" :visible="visible" :modal="true"
             :close-on-click-modal="false"
             :close-on-press-escape="false" :modal-append-to-body="false" :show-close="false" width="75%"
             @close="clearValidation">

    <el-card>
    <el-form ref="supplierForm" :model="supplier" :rules="rules" label-position="top">

      <el-row :gutter="20">
        <!-- LEFT COLUMN -->
        <el-col :span="12">

          <el-form-item label="Εισάγετε το όνομα εταιρίας"
                        prop="companyName">
            <el-input prefix-icon="fa fa-user"
                      v-model="supplier.companyName"
                      placeholder="Όνομα Εταιρίας"
                      autoComplete="companyName">
            </el-input>
          </el-form-item>

          <el-form-item label="Εισάγετε το όνομα του προμηθευτή"
                        prop="firstName">
            <el-input prefix-icon="fa fa-user"
                      v-model="supplier.firstName"
                      placeholder="Όνομα"
                      autoComplete="firstName">
            </el-input>
          </el-form-item>

          <el-form-item label="Εισάγετε το επίθετο του προμηθευτή"
                        prop="lastName">
            <el-input prefix-icon="fa fa-user"
                      v-model="supplier.lastName"
                      placeholder="Επίθετο"
                      autoComplete="lastName">
            </el-input>
          </el-form-item>

        </el-col>

        <!-- RIGHT COLUMN -->
        <el-col :span="12">

          <el-form-item label="Εισάγετε Α.Φ.Μ."
                        prop="vatNumber">
            <el-input prefix-icon="fa fa-user"
                      v-model="supplier.vatNumber"
                      placeholder="ΑΦΜ"
                      autoComplete="vatNumber">
            </el-input>
          </el-form-item>

          <el-form-item label="Εισάγετε Δ.Ο.Υ."
                        prop="irsOffice">
            <el-input prefix-icon="fa fa-user"
                      v-model="supplier.irsOffice"
                      placeholder="ΔΟΥ"
                      autoComplete="irsOffice">
            </el-input>
          </el-form-item>

          <el-form-item label="Εισάγετε Διεύθυνση"
                        prop="address">
            <el-input prefix-icon="fa fa-user"
                      v-model="supplier.address"
                      placeholder="Διεύθυνση"
                      autoComplete="address">
            </el-input>
          </el-form-item>
        </el-col>
        </el-row>
        <el-row :gutter="20">
        <!-- LEFT COLUMN -->
        <el-col :span="12">

          <el-form-item label="Εισάγετε T.K."
                        prop="zipCode">
            <el-input prefix-icon="fa fa-phone"
                      v-model="supplier.zipCode"
                      placeholder="T.K."
                      autoComplete="zipCode">
            </el-input>
          </el-form-item>

          <el-form-item label="Εισάγετε Χώρα"
                        prop="country">
            <el-input prefix-icon="fa fa-phone"
                      v-model="supplier.country"
                      placeholder="Χώρα"
                      autoComplete="country">
            </el-input>
          </el-form-item>

        </el-col>

        <!-- LEFT COLUMN -->
        <el-col :span="12">

          <el-form-item label="Εισάγετε Πόλη"
                        prop="city">
            <el-input prefix-icon="fa fa-phone"
                      v-model="supplier.city"
                      placeholder="Πόλη"
                      autoComplete="city">
            </el-input>
          </el-form-item>

        </el-col>
      </el-row>
    </el-form>
      <el-row>
        <el-col style="text-align: right">
          <el-button type="success"
                     icon="fa fa-save"
                     @click="save"> Αποθήκευση </el-button>

          <el-button type="danger"
                     icon="fa fa-remove"
                     @click="confirmDelete"
                     :disabled="!isDeletable"> Διαγραφή </el-button>
        </el-col>
      </el-row>
    </el-card>

    <div slot="footer" class="dialog-footer card-footer">
      <el-button type="warning"
                 icon="el-icon-back"
                 @click="cancel"> Επιστροφή </el-button>
    </div>

  </el-dialog>
</template>
<script src="./SupplierVM.js"></script>
